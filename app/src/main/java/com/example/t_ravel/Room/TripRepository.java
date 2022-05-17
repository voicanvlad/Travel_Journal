package com.example.t_ravel.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    private TripDao tripDao;
    private LiveData<List<Trip>> trips;

    public TripRepository(Application application){
        TripDatabase tripDatabase = TripDatabase.getDatabase(application);
        tripDao = tripDatabase.tripDao();
        trips = tripDao.getAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips() {

        return trips;
    }
    public void insert(Trip trip){
        TripDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }

    public void update(Trip trip){
        TripDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.updateTrip(trip);
        });
    }

    public void delete(Trip trip){
        TripDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.deleteTrip(trip);
        });
    }




}
