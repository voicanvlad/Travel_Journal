package com.example.t_ravel.ui.Favorites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t_ravel.Adapter.TripAdapter;
import com.example.t_ravel.R;
import com.example.t_ravel.Room.Trip;
import com.example.t_ravel.Room.TripDao;
import com.example.t_ravel.Room.TripDatabase;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {
    private RecyclerView recyclerViewTrips;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    public TripDatabase tripDataBase;
    public TripDao tripDao;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_favorites_fragment, container, false);
        tripDataBase = TripDatabase.getDatabase(getContext());
        tripDao = tripDataBase.tripDao();


        swipeRefreshLayout = view.findViewById(R.id.swiperLayoutFav);

        recyclerViewTrips = view.findViewById(R.id.recyclerViewTripsFav);
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getActivity()));
        //adapter = new TripAdapter((ArrayList<Trip>) tripDao.getAllFavoriteTrips());
        recyclerViewTrips.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }

    private void refreshList() {
        //adapter = new TripAdapter((ArrayList<Trip>) tripDao.getAllFavoriteTrips());
        recyclerViewTrips.setAdapter(adapter);
    }
}