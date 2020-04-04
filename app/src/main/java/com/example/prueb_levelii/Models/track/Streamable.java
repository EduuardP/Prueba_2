package com.example.prueb_levelii.Models.track;

import com.google.gson.annotations.SerializedName;

class Streamable {

    @SerializedName("#text") public String streamable;
    @SerializedName("fulltrack") public String fulltrack;


    public Streamable(String streamable, String fulltrack) {
        this.streamable = streamable;
        this.fulltrack = fulltrack;
    }

    public String getStreamable() {
        return streamable;
    }

    public String getFulltrack() {
        return this.fulltrack;
    }
}
