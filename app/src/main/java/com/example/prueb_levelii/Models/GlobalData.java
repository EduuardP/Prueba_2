package com.example.prueb_levelii.Models;

import java.util.List;

public class GlobalData {



  private List<DataArtist> artist;

  public GlobalData(List<DataArtist> artist){

    this.artist = artist;
  }

  public void setArtist(List<DataArtist> artist) {
    this.artist = artist;
  }

  public List<DataArtist> getArtist(){

    return this.artist;
  }

}

