package fi.dreamers.microbusiness.mocked;

import com.cleveroad.loopbar.adapter.ICategoryItem;

import java.util.ArrayList;
import java.util.List;

import fi.dreamers.microbusiness.R;
import fi.dreamers.microbusiness.mocked.model.CategoryItem;

/**
 * Created by mis on 8/5/2016.
 */
public class MockedCategoryItems {
    public static List<ICategoryItem> getCategoryItemsUniq() {
        List<ICategoryItem> items = new ArrayList<>();
        items.add(new CategoryItem(R.drawable.ic_all, "All"));
        items.add(new CategoryItem(R.drawable.ic_electronics, "Laptops"));
        items.add(new CategoryItem(R.drawable.ic_cloths, "Cloths"));
        items.add(new CategoryItem(R.drawable.ic_home, "Home"));
        items.add(new CategoryItem(R.drawable.ic_sports, "Sports"));
        items.add(new CategoryItem(R.drawable.ic_book, "Books"));
        items.add(new CategoryItem(R.drawable.ic_toys, "Toys"));
        items.add(new CategoryItem(R.drawable.ic_services, "Services"));
        return items;
    }
}
