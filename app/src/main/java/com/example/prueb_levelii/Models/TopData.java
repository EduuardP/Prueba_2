package com.example.prueb_levelii.Models;

public class TopData {

   private GlobalData topartists;

   public TopData(GlobalData topartists){

      this.topartists = topartists;
   }

   public void setTopartists(GlobalData topartists) {
      this.topartists = topartists;
   }

   public GlobalData getTopartists(){

      return this.topartists;
   }

   @Override
   public String toString() {
      return "TopData{" +
              "topartists=" + topartists +
              '}';
   }
}
