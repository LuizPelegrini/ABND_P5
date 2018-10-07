package com.example.android.abnd_p5;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

        Resources resources = getResources();

        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(resources.getString(R.string.colony),
                resources.getString(R.string.chinese) + ", " + resources.getString(R.string.indian),
                resources.getString(R.string.colony_address),
                R.drawable.colony));
        restaurants.add(new Restaurant(resources.getString(R.string.summer_pavilion),
                resources.getString(R.string.cantonese),
                resources.getString(R.string.summer_pavilion_address),
                R.drawable.summer_pavilion));
        restaurants.add(new Restaurant(resources.getString(R.string.cure),
                resources.getString(R.string.western),
                resources.getString(R.string.cure_address),
                R.drawable.cure));
        restaurants.add(new Restaurant(resources.getString(R.string.artemis),
                resources.getString(R.string.mediterranean),
                resources.getString(R.string.artemis_address),
                R.drawable.artemis));


        ListView listView = rootView.findViewById(R.id.list_view);
        RestaurantAdapter adapter = new RestaurantAdapter(getActivity(), restaurants);
        listView.setAdapter(adapter);

        return rootView;
    }

}
