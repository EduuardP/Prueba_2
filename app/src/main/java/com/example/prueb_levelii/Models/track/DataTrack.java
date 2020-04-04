package com.example.prueb_levelii.Models.track;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.google.gson.annotations.SerializedName;

public class DataTrack {

    private String name;
    private String duration;
    private  String listeners;
    private  String mbid;
    private  String url;
    private Streamable streamable;
    private DataArtist artist;
    @SerializedName("@attrib") private Attrib attrib;

    public DataTrack(String name, String duration, String listeners, String mbid, String url, Streamable streamable, DataArtist artist, Attrib attrib) {
        this.name = name;
        this.duration = duration;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.attrib = attrib;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getListeners() {
        return listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public DataArtist getArtist() {
        return artist;
    }

    public Attrib getAttrib() {
        return attrib;
    }
}
