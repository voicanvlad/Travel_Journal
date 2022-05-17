package com.example.t_ravel.Adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.t_ravel.R;


public class TripViewHolder extends RecyclerView.ViewHolder  {
    private final TextView textViewName, textViewDestination, nameTripType, namePrice, tripRating;
    private final ImageButton buttonFavorite;
    private final ImageView tripPicture;
    private long tripId;
    private boolean isFavorite;
    private CardView parentLayout;


    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tripPicture = itemView.findViewById(R.id.tripImage);
        textViewName = itemView.findViewById(R.id.textTripName);
        textViewDestination = itemView.findViewById(R.id.textDestination);
        this.buttonFavorite = itemView.findViewById(R.id.button_favorite);
        this.nameTripType = itemView.findViewById(R.id.textTripType);
        this.namePrice = itemView.findViewById(R.id.textPrice);
        this.tripRating = itemView.findViewById(R.id.tripRatingTextView);
        parentLayout = itemView.findViewById(R.id.parent_layout_trip);

    }

    void setFavorite(boolean favorite) {

        isFavorite = favorite;
    }
    public long getTripId() {

        return tripId;
    }

    public void setTripId(long tripId) {

        this.tripId = tripId;
    }
    public TextView getTextViewName() {

        return textViewName;
    }

    public TextView getTextViewDestination() {
        return textViewDestination;
    }

    public ImageButton getButtonFavorite() {

        return buttonFavorite;
    }

    public TextView getNameTripType() {

        return nameTripType;
    }

    public TextView getNamePrice() {

        return namePrice;
    }

    public TextView getTripRating() {

        return tripRating;
    }

    public ImageView getTripPicture() {

        return tripPicture;
    }


}
