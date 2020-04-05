package com.example.prueb_levelii.ui.topArtist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.R;
import com.example.prueb_levelii.Services.ServiceApi;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class ArtistFragment extends Fragment {

    ListView listArtist;
    ArtistAdapter artistAdapter;
    private Disposable disposable;
    ServiceApi serviceApi = new ServiceApi();

    public ArtistFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        listArtist = (ListView) view.findViewById(R.id.listArtist);

        serviceApi = new ServiceApi();
        serviceApi.observableArtist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerArtist());


        listArtist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),
                        ""+artistAdapter.getItem(position).getName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return view;
    }





    public Observer observerArtist(){
        return new Observer<List<DataArtist>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(List<DataArtist> artists) {

                 artistAdapter = new ArtistAdapter(getContext(),R.layout.item_artist,artists);
                  listArtist.setAdapter(artistAdapter);

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(getContext(),R.string.errorData,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //disposable.dispose();

    }

    @Override
    public void onPause() {
        super.onPause();
        disposable.dispose();
    }
}
