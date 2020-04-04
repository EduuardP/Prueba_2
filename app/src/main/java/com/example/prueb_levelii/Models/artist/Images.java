package com.example.prueb_levelii.Models.artist;

import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("#text") public String url;
    @SerializedName("size") public String size;

    public Images(String url, String size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
