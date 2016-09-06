package fi.dreamers.microbusiness.mocked.model;

/**
 * Created by mis on 8/5/2016.
 */
public class SubCategoryItem {
    private int id;
    private String title;
    private int imageSrc;

    public SubCategoryItem(int id, String title, int imageSrc) {
        this.id = id;
        this.title = title;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getImageSrc() {
        return imageSrc;
    }
}
