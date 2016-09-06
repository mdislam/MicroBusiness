package fi.dreamers.microbusiness.mocked.model;

import com.cleveroad.loopbar.adapter.ICategoryItem;

/**
 * Created by mis on 8/5/2016.
 */
public class CategoryItem implements ICategoryItem {
    private int categoryItemDrawableId;
    private String categoryName;

    public CategoryItem(int categoryItemDrawableId, String categoryName) {
        this.categoryItemDrawableId = categoryItemDrawableId;
        this.categoryName = categoryName;
    }

    @Override
    public int getCategoryIconDrawable() {
        return categoryItemDrawableId;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CategoryItem && ((CategoryItem) o).categoryName.equals(categoryName);
    }
}
