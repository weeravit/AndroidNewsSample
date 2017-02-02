package me.weeravit.androidnewssample.module.news;

import com.google.gson.annotations.SerializedName;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class News {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("link")
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
