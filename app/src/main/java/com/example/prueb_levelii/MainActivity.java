package com.example.prueb_levelii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.ui.topArtist.ArtistAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;
    private Disposable disposable;
    ListView listArtist;
    ArtistAdapter artistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


    public Observer observerArtist(){
        return new Observer<List<DataArtist>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(List<DataArtist> artists) {

               // artistAdapter = new ArtistAdapter(getApplicationContext(),R.layout.item_artist,artists);
              //  listArtist.setAdapter(artistAdapter);

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(getApplicationContext(),R.string.errorData,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };

    }


}
