package com.example.prueb_levelii.Services;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.Models.artist.TopArtist;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceApi {

    String url = "https://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=colombia&api_key=829751643419a7128b7ada50de590067&limit=20&format=json";
    TopArtist dataArray = null ;

    public Observable observableArtist(){
        return Observable.create(new ObservableOnSubscribe<List<DataArtist>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<DataArtist>> emitter) {

                try{
                    emitter.onNext(dataApi());
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }


            }
        });

    }
    public List<DataArtist> dataApi(){
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            final String myResponse = response.body().string();

            Gson gson = new Gson();
            dataArray = gson.fromJson(myResponse, TopArtist.class);



        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return dataArray.getTopartists().getArtist();
    }
}
