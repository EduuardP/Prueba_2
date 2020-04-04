package com.example.prueb_levelii.Models.artist;

public class TopArtist {

   private GlobalDataArtist topartists;

   public TopArtist(GlobalDataArtist topartists){

      this.topartists = topartists;
   }

   public void setTopartists(GlobalDataArtist topartists) {
      this.topartists = topartists;
   }

   public GlobalDataArtist getTopartists(){

      return this.topartists;
   }

   @Override
   public String toString() {
      return "TopData{" +
              "topartists=" + topartists +
              '}';
   }
}
