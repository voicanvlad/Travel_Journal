package com.example.t_ravel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.t_ravel.Adapter.TripAdapter;
import com.example.t_ravel.R;
import com.example.t_ravel.Room.Trip;
import com.example.t_ravel.Room.TripDao;
import com.example.t_ravel.Room.TripDatabase;
import com.example.t_ravel.Room.TripViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewTrips;
    public TripDatabase tripDataBase;
    public TripDao tripDao;
    private List<Trip> tripList = new ArrayList<>();
    private TripViewModel tripViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TripAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    recyclerViewTrips = view.findViewById(R.id.recyclerViewTrips);
    tripViewModel = new ViewModelProvider(this).get(TripViewModel.class);
    tripViewModel.getAllTrips().observe(requireActivity(),trips -> setTrips(tripViewModel.getAllTrips().getValue()));
    setupRecyclerViewTrips();

        return view;
    }

    private void prePopulateTrips(){
        tripList=new ArrayList<>();
        Trip trip = new Trip("Disneyland", "Paris", "City Break", 1000, 5, "23-04-2022", "27-04-2022", "https://images.unsplash.com/photo-1590144662036-33bf0ebd2c7f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80");
        tripViewModel.insert(trip);
        tripList.add(trip);
        Trip trip2 = new Trip("Shopping", "Milano", "City Break", 600, 4, "20-05-2022", "23-05-2022", "https://images.unsplash.com/photo-1617102827974-c3f440b2ed70?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=863&q=80");
        tripViewModel.insert(trip2);
        tripList.add(trip2);
        Trip trip3 = new Trip("Ski", "France", "Vacation", 2000, 4.5, "28-12-2022", "03-01-2022", "https://images.unsplash.com/photo-1524992622325-a5b57c403ad3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80");
        tripViewModel.insert(trip3);
        tripList.add(trip3);
        Trip trip4 = new Trip("Clubbing", "Barcelona", "City Break", 1800, 5, "05-07-2022", "09-07-2022", "https://images.unsplash.com/photo-1556035511-3168381ea4d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80");
        tripViewModel.insert(trip4);
        tripList.add(trip4);
        Trip trip5 = new Trip("Exotic Vacations", "Maldives", "Honeymoon", 4400, 5, "13-02-2023", "20-02-2023", "https://images.unsplash.com/photo-1586861635167-e5223aadc9fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=388&q=80");
        tripViewModel.insert(trip5);
        tripList.add(trip5);
    }

    private TripAdapter getTripsAdapter() {
        return new TripAdapter(tripList);
    }

    public void setTrips(List<Trip> trips){
        this.tripList = trips;
    }
    private void setupLayoutManager() {
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupRecyclerViewTrips(){
        prePopulateTrips();
        setupLayoutManager();
        recyclerViewTrips.setAdapter(getTripsAdapter());
    }


}

