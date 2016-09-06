package fi.dreamers.microbusiness.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fi.dreamers.microbusiness.R;
import fi.dreamers.microbusiness.mocked.model.SubCategoryItem;

/**
 * Created by mis on 8/5/2016.
 */
public class RecycleCardsAdapter extends RecyclerView.Adapter<RecycleCardsAdapter.CardViewHolder> {

    private ArrayList<SubCategoryItem> mSubCategoryItems;

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageHolder;
        TextView mTextTitle;
        ImageView mImageFavorite;

        public CardViewHolder(View itemView) {
            super(itemView);
            this.mImageHolder = (ImageView) itemView.findViewById(R.id.image_holder);
            this.mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
            this.mImageFavorite = (ImageView) itemView.findViewById(R.id.image_favorit);
        }
    }

    public RecycleCardsAdapter(ArrayList<SubCategoryItem> subCategoryItems) {
        this.mSubCategoryItems = subCategoryItems;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_card_view, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int listPosition) {
        SubCategoryItem album = mSubCategoryItems.get(listPosition);
        holder.mImageHolder.setImageResource(album.getImageSrc());
        holder.mTextTitle.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return mSubCategoryItems.size();
    }
}
