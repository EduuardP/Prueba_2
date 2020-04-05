package com.example.prueb_levelii.Services;

import android.util.Log;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.Models.artist.TopArtist;
import com.example.prueb_levelii.Models.track.DataTrack;
import com.example.prueb_levelii.Models.track.TopTrack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceApi {

    OkHttpClient client;
    private static final String TAG = "ServiceApi" ;


    String urlArtist = "https://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=colombia&api_key=829751643419a7128b7ada50de590067&limit=20&format=json";
    TopArtist topArtist = null ;


    String urlTrack = "https://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=colombia&api_key=829751643419a7128b7ada50de590067&limit=20&format=json";
    public TopTrack topTrack;

    public Observable observableArtist(){
        return Observable.create(new ObservableOnSubscribe<List<DataArtist>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<DataArtist>> emitter) {

                try{
                    emitter.onNext(dataApiArtist());
                    emitter.onComplete();

                } catch (Exception e) {
                    emitter.onError(e);
                }


            }
        });

    }

    public Observable observableTrack(){
        return Observable.create(new ObservableOnSubscribe<List<DataTrack>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<DataTrack>> emitter) {

                try{
                    List<DataTrack> dataTracks = dataApiTrack();
                    emitter.onNext(dataTracks);
                    emitter.onComplete();

                } catch (Exception e) {
                    emitter.onError(e);
                }


            }
        });

    }

    public List<DataArtist> dataApiArtist(){
        try {

            client = new OkHttpClient();
            Request request = new Request.Builder().url(urlArtist).build();
            Response response = client.newCall(request).execute();
            final String myResponse = response.body().string();


            Gson gson = new Gson();
            topArtist = gson.fromJson(myResponse, TopArtist.class);



        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return topArtist.getTopartists().getArtist();
    }

    public List<DataTrack> dataApiTrack(){

        try {
            OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder()
                    .url(urlTrack)
                    .build();
            Response response = client.newCall(request).execute();
            final String myResponse = response.body().string();
            Log.d(TAG, "onResponse: "+myResponse);
            Gson gson = new Gson();
            topTrack = gson.fromJson(myResponse,TopTrack.class);

        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }




        return topTrack.getTracks().getTrack();
    }
}
