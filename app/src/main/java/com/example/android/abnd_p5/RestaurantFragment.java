package com.example.android.abnd_p5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {

    ArrayList<Restaurant> restaurants;

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant A", "Cuisine A", "Address A", R.drawable.ic_launcher_foreground));
        restaurants.add(new Restaurant("Restaurant B", "Cuisine B", "Address B", R.drawable.ic_launcher_background));
        restaurants.add(new Restaurant("Restaurant C", "Cuisine C", "Address C", R.drawable.ic_launcher_background));
        restaurants.add(new Restaurant("Restaurant D", "Cuisine D", "Address D", R.drawable.ic_launcher_background));
        restaurants.add(new Restaurant("Restaurant E", "Cuisine E", "Address E", R.drawable.ic_launcher_background));

        ListView listView = rootView.findViewById(R.id.list_view);
        RestaurantAdapter adapter = new RestaurantAdapter(getActivity(), restaurants);
        listView.setAdapter(adapter);

        return rootView;
    }

}
