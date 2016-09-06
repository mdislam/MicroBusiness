package fi.dreamers.microbusiness.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.cleveroad.loopbar.adapter.ICategoryItem;
import com.cleveroad.loopbar.adapter.SimpleCategoriesAdapter;
import com.cleveroad.loopbar.model.MockedItemsFactory;
import com.cleveroad.loopbar.widget.LoopBarView;
import com.cleveroad.loopbar.widget.OnItemClickListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import fi.dreamers.microbusiness.R;
import fi.dreamers.microbusiness.application.ApplicationCore;
import fi.dreamers.microbusiness.mocked.MockedCategoryItems;
import fi.dreamers.microbusiness.mocked.MockedSubCategoryItems;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MaterialSearchView searchView;
    private LoopBarView loopBarView;
    private SimpleCategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ApplicationCore core = (ApplicationCore) getApplicationContext();

        // setting profile name and email from application core
        NavigationView navHeader = (NavigationView) findViewById(R.id.nav_view);

        TextView profileName = (TextView) navHeader.getHeaderView(0).findViewById(R.id.profile_name);
        TextView profileEmail = (TextView) navHeader.getHeaderView(0).findViewById(R.id.profile_email);

        profileName.setText(core.getName());
        profileEmail.setText(core.getEmail());

        //navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //material search view
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                Toast.makeText(HomeActivity.this, "You have searched for " + query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
        //recyclerview
        final RecyclerView albumsRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        albumsRecycleView.setHasFixedSize(true);

        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        albumsRecycleView.setLayoutManager(recycleLayoutManager);

        RecycleCardsAdapter subCategoryAdapter1 = new RecycleCardsAdapter(MockedSubCategoryItems.getSubCategoryItems1());
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(subCategoryAdapter1);
        alphaAdapter.setDuration(1500);
        albumsRecycleView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));

        //loopbar view
        loopBarView = (LoopBarView) findViewById(R.id.endlessView);
        categoriesAdapter = new SimpleCategoriesAdapter(MockedCategoryItems.getCategoryItemsUniq());
        loopBarView.setCategoriesAdapter(categoriesAdapter);
        loopBarView.addOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                ICategoryItem categoryItem = categoriesAdapter.getItem(position);
                Toast.makeText(HomeActivity.this, "You have Clicked" + " - " + categoryItem.getCategoryName(), Toast.LENGTH_SHORT).show();
                if(categoryItem.getCategoryName().equalsIgnoreCase("all")){
                    RecycleCardsAdapter subCategoryAdapter1 = new RecycleCardsAdapter(MockedSubCategoryItems.getSubCategoryItems1());
                    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(subCategoryAdapter1);
                    alphaAdapter.setDuration(1500);
                    albumsRecycleView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
                }
                else if(categoryItem.getCategoryName().equalsIgnoreCase("cloths")){
                    RecycleCardsAdapter subCategoryAdapter1 = new RecycleCardsAdapter(MockedSubCategoryItems.getSubCategoryItems2());
                    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(subCategoryAdapter1);
                    alphaAdapter.setDuration(1500);
                    albumsRecycleView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
                }
                else if(categoryItem.getCategoryName().equalsIgnoreCase("sports")){
                    RecycleCardsAdapter subCategoryAdapter1 = new RecycleCardsAdapter(MockedSubCategoryItems.getSubCategoryItems3());
                    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(subCategoryAdapter1);
                    alphaAdapter.setDuration(1500);
                    albumsRecycleView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
                }
                else {
                    RecycleCardsAdapter subCategoryAdapter1 = new RecycleCardsAdapter(MockedSubCategoryItems.getSubCategoryItems1());
                    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(subCategoryAdapter1);
                    alphaAdapter.setDuration(1500);
                    albumsRecycleView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_favorites) {
            // Handle the favorites action
            Intent favoriteIntent = new Intent(this, FavoritesActivity.class);
            startActivity(favoriteIntent);
        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_add_account) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
