package com.example.prueb_levelii.ui.topTrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrackAdapter extends ArrayAdapter<DataArtist> {


    private Context mContext;
    private int mLayoutResourceId;
    private List<DataArtist> artist;

    public TrackAdapter(@NonNull Context context, int resource, @NonNull List<DataArtist> artist) {
        super(context, resource, artist);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.artist = artist;
    }


    @Nullable
    @Override
    public DataArtist getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        PlaceHolder holder;

        if (row==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlaceHolder();

            holder.nameArtist = (TextView) row.findViewById(R.id.nameArtist);
            holder.numOyentes = (TextView) row.findViewById(R.id.numOyentesArtist);
            holder.urlArtist = (TextView) row.findViewById(R.id.urlArtist);

            holder.imageView = (ImageView) row.findViewById(R.id.imageArtist);

            row.setTag(holder);
        }
        else
        {
            holder = (PlaceHolder) row.getTag();
        }



        holder.nameArtist.setText(artist.get(position).getName());
        holder.numOyentes.setText(artist.get(position).getListeners());
        holder.urlArtist.setText(artist.get(position).getUrl());

        Picasso.with(getContext())
                .load(artist.get(position).getImage().get(2).getUrl())
                .into(holder.imageView);




        return row;
    }



    private class PlaceHolder {
        TextView nameArtist;
        TextView numOyentes;
        TextView urlArtist;
        ImageView imageView;
    }
}
