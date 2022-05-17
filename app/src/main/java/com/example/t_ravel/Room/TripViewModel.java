package com.example.t_ravel.Room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.t_ravel.Room.Trip;
import com.example.t_ravel.Room.TripRepository;

import java.util.List;

public class TripViewModel extends AndroidViewModel {
    private TripRepository tripRepository; //incearca cu static
    private LiveData<List<Trip>> trips;

    public TripViewModel(@NonNull Application application) {
        super(application);
        tripRepository = new TripRepository(application);
        trips = tripRepository.getAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips() {
        return trips;
    }

    public void insert(Trip trip) {
        tripRepository.insert(trip);
    }

    void update(Trip trip) {
        tripRepository.update(trip);
    }

    void delete(Trip trip) {
        tripRepository.delete(trip);
    }
}