package com.example.t_ravel.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t_ravel.R;
import com.example.t_ravel.Room.Trip;
import com.squareup.picasso.Picasso;

import java.util.List;


public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {
    private List<Trip> tripList;

    public TripAdapter(List<Trip> tripList) {
        this.tripList = tripList;
       // notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new TripViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.t_ravel.Adapter.TripViewHolder holder, final int position) {
        Trip currentTrip = tripList.get(position);
        holder.setTripId(currentTrip.getTripId());
        Picasso.get().load(currentTrip.getImage()).into(holder.getTripPicture());
        holder.setFavorite(currentTrip.isFavorite());
        holder.getTextViewName().setText(currentTrip.getName());
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        holder.getNameTripType().setText(currentTrip.getTripType());
        String priceString = String.valueOf(currentTrip.getPrice() + " €");
        String ratingString = String.valueOf(currentTrip.getRating() + "★");
        holder.getNamePrice().setText(priceString);
        holder.getTripRating().setText(ratingString);
    }



    public Trip getTripAt(int position) {
        return tripList.get(position);
    }
    @Override
    public int getItemCount() {
        return tripList.size();
    }
}
