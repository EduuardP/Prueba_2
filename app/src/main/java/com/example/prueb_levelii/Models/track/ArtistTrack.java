package com.example.prueb_levelii.Models.track;

public class ArtistTrack {
    private String name;
    private String mbid;
    private String url;

    public ArtistTrack(String name, String mbid, String url) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }
}
