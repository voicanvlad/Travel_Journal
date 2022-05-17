package com.example.t_ravel.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "trip_table")
public class Trip implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_trip")
    private int tripId;
    private String name;
    private String destination;
    private String TripType;
    private int price;
    private double rating;

    private String startDate;
    private String endDate;
    private String image;
    private boolean isFavorite;

    public Trip(String name, String destination, String TripType, int price, double rating, String startDate, String endDate, String image) {

        this.name = name;
        this.destination = destination;
        this.TripType = TripType;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.image = image;
    }

    public Trip(int tripId, String name, String destination, String tripType, int price, double rating, String startDate, String endDate, String image, boolean isFavorite) {
        this.tripId = tripId;
        this.name = name;
        this.destination = destination;
        TripType = tripType;
        this.price = price;
        this.rating = rating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.isFavorite = isFavorite;

    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripType() {
        return TripType;
    }

    public void setTripType(String tripType) {
        TripType = tripType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", TripType=" + TripType +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", isFavorite=" + isFavorite +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rating=" + rating +
                '}';
    }
}
