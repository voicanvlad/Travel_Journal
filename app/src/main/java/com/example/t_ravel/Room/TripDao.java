package com.example.t_ravel.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TripDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Trip trip);

    @Update
    void updateTrip(Trip trip);

    @Delete
    void deleteTrip(Trip trip);

    @Query("DELETE FROM trip_table")
    void deleteAll();

    @Query("SELECT * from trip_table ORDER BY id_trip")
    LiveData<List<Trip>> getAllTrips();

    @Query("SELECT * FROM trip_table WHERE id_trip = :tripId")
    Trip getTrip(long tripId);

    @Query("SELECT * FROM trip_table WHERE isFavorite = 1")
    List<Trip> getAllFavoriteTrips();

    @Query("DELETE FROM trip_table WHERE id_trip = :tripId")
    void deleteTripById(long tripId);

    @Query("UPDATE trip_table SET isFavorite = 1 WHERE id_trip = :tripId")
    void setFavorite(long tripId);

    @Query("UPDATE trip_table SET isFavorite = 0 WHERE id_trip = :tripId")
    void removeFavorite(long tripId);

}
