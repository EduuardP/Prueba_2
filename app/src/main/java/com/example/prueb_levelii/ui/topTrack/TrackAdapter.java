package com.example.prueb_levelii.ui.topTrack;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prueb_levelii.Models.artist.DataArtist;
import com.example.prueb_levelii.Models.track.DataTrack;
import com.example.prueb_levelii.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TrackAdapter extends ArrayAdapter<DataTrack> {


    private Context mContext;
    private int mLayoutResourceId;
    private List<DataTrack> tracks;

    public TrackAdapter(@NonNull Context context, int resource, @NonNull List<DataTrack> tracks) {
        super(context, resource, tracks);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.tracks = tracks;
    }


    @Nullable
    @Override
    public DataTrack getItem(int position) {
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


            holder.nameTask = (TextView) row.findViewById(R.id.nameTrack);
            holder.numOyentes = (TextView) row.findViewById(R.id.numOyentesTrack);
            holder.rank = (TextView) row.findViewById(R.id.numRankTrack);
            holder.nameArtist = (TextView) row.findViewById(R.id.nameArtistTrack);
            holder.duration = (TextView) row.findViewById(R.id.numDurationTrack);
            holder.imageView = (ImageView) row.findViewById(R.id.imageArtistTrack);

            row.setTag(holder);
        }
        else
        {
            holder = (PlaceHolder) row.getTag();
        }


        holder.nameTask.setText(tracks.get(position).getName());
        holder.numOyentes.setText(tracks.get(position).getListeners());
        holder.rank.setText(tracks.get(position).getAttrib().getRank());
        holder.nameArtist.setText(tracks.get(position).getArtist().getName());

        int duracion =  parseInt(tracks.get(position).getDuration());
        int minutos = duracion/60;
        int segundos = duracion%60;
        holder.duration.setText(""+minutos+":"+segundos);

        Picasso.with(getContext())
                .load(tracks.get(position).getImage().get(2).getUrl())
                .into(holder.imageView);




        return row;
    }



    private class PlaceHolder {
        TextView nameTask;
        TextView nameArtist;
        TextView numOyentes;
        TextView rank;
        TextView duration;
        ImageView imageView;
    }
}
