package com.example.prueb_levelii.Models.track;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.Models.artist.Images;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataTrack {

    private String name;
    private String duration;
    private  String listeners;
    private  String mbid;
    private  String url;
    private Streamable streamable;
    private ArtistTrack artist;
    private List<Images> image;
    @SerializedName("@attr") private Attrib attrib;

    public DataTrack(String name, String duration, String listeners, String mbid, String url, Streamable streamable, ArtistTrack artist, List<Images> image, Attrib attrib) {
        this.name = name;
        this.duration = duration;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.image = image;
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

    public ArtistTrack getArtist() {
        return artist;
    }

    public List<Images> getImage() {
        return image;
    }

    public Attrib getAttrib() {
        return attrib;
    }
}
