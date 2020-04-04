package com.example.prueb_levelii.Models.artist;

import java.util.List;

public class GlobalDataArtist {



  private List<DataArtist> artist;

  public GlobalDataArtist(List<DataArtist> artist){

    this.artist = artist;
  }

  public void setArtist(List<DataArtist> artist) {
    this.artist = artist;
  }

  public List<DataArtist> getArtist(){

    return this.artist;
  }

}

