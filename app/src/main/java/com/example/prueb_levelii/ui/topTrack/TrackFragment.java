package com.example.prueb_levelii.ui.topTrack;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prueb_levelii.MainActivity;
import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.Models.track.DataTrack;
import com.example.prueb_levelii.Models.track.TopTrack;
import com.example.prueb_levelii.R;
import com.example.prueb_levelii.Services.ServiceApi;
import com.example.prueb_levelii.ui.topArtist.ArtistAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * create an instance of this fragment.
 */
public class TrackFragment extends Fragment {

    private Disposable disposable;
    ServiceApi serviceApi = new ServiceApi();
    String urlTrack = "https://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=colombia&api_key=829751643419a7128b7ada50de590067&limit=20&format=json";
    TrackAdapter trackAdapter;
    ListView listView;

    private static final String TAG = "TrackFragment" ;

    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track, container, false);
        listView = (ListView) view.findViewById(R.id.listTrack);
        serviceApi = new ServiceApi();
        serviceApi.observableTrack()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerTrack());


        return view;
    }

    public Observer observerTrack(){
        return new Observer<List<DataTrack>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(List<DataTrack> tracks) {
                Log.d(TAG, "onNext: "+tracks.get(0).getName());
                trackAdapter = new TrackAdapter(getContext(),R.layout.item_track,tracks);
                listView.setAdapter(trackAdapter);
                Toast.makeText(getContext(),tracks.get(0).getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };

    }








    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // disposable.dispose();

    }

    @Override
    public void onPause() {
        super.onPause();
        disposable.dispose();
    }
}
