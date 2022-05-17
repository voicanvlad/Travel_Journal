package com.example.t_ravel.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Trip.class}, version = 1, exportSchema = false)
public abstract class TripDatabase extends RoomDatabase {

    public abstract TripDao tripDao();

private static volatile TripDatabase INSTANCE;
private static final int NUMBER_OF_THREADS=4;
static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

public static TripDatabase getDatabase(final Context context){
    if(INSTANCE==null){
        synchronized (TripDatabase.class){
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),TripDatabase.class,"trip_database").allowMainThreadQueries().build(); //cream instanta a bazei de date
            }
        }
    }
    return INSTANCE;
}
}
