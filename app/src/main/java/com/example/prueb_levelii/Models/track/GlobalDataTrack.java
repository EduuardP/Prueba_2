package com.example.prueb_levelii.Models.track;



import java.util.List;

public class GlobalDataTrack {

    private List<DataTrack> track;

    public GlobalDataTrack(List<DataTrack> track) {
        this.track = track;
    }

    public List<DataTrack> getTrack() {
        return this.track;
    }
}
