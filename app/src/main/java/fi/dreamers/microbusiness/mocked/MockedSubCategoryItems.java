package fi.dreamers.microbusiness.mocked;

import java.util.ArrayList;

import fi.dreamers.microbusiness.R;
import fi.dreamers.microbusiness.mocked.model.SubCategoryItem;

/**
 * Created by mis on 8/5/2016.
 */
public class MockedSubCategoryItems {
    public static ArrayList<SubCategoryItem> getSubCategoryItems1(){
        ArrayList<SubCategoryItem> items = new ArrayList<>();

        items.add(new SubCategoryItem(1, "Item 1", R.drawable.pic_1));
        items.add(new SubCategoryItem(2, "Item 2", R.drawable.pic_2));
        items.add(new SubCategoryItem(3, "Item 3", R.drawable.pic_3));
        items.add(new SubCategoryItem(4, "Item 4", R.drawable.pic_4));
        items.add(new SubCategoryItem(5, "Item 5", R.drawable.pic_5));
        items.add(new SubCategoryItem(6, "Item 6", R.drawable.pic_6));
        items.add(new SubCategoryItem(7, "Item 7", R.drawable.pic_7));
        items.add(new SubCategoryItem(8, "Item 8", R.drawable.pic_8));
        items.add(new SubCategoryItem(9, "Item 9", R.drawable.pic_9));
        items.add(new SubCategoryItem(10, "Item 10", R.drawable.pic_10));
        items.add(new SubCategoryItem(11, "Item 11", R.drawable.pic_11));

        return items;
    }

    public static ArrayList<SubCategoryItem> getSubCategoryItems2(){
        ArrayList<SubCategoryItem> items = new ArrayList<>();

        items.add(new SubCategoryItem(2, "Item 2", R.drawable.pic_2));
        items.add(new SubCategoryItem(4, "Item 4", R.drawable.pic_4));
        items.add(new SubCategoryItem(6, "Item 6", R.drawable.pic_6));
        items.add(new SubCategoryItem(8, "Item 8", R.drawable.pic_8));

        return items;
    }

    public static ArrayList<SubCategoryItem> getSubCategoryItems3(){
        ArrayList<SubCategoryItem> items = new ArrayList<>();

        items.add(new SubCategoryItem(1, "Item 1", R.drawable.pic_1));
        items.add(new SubCategoryItem(3, "Item 3", R.drawable.pic_3));
        items.add(new SubCategoryItem(7, "Item 7", R.drawable.pic_7));
        items.add(new SubCategoryItem(9, "Item 9", R.drawable.pic_9));
        items.add(new SubCategoryItem(11, "Item 11", R.drawable.pic_11));

        return items;
    }
}
