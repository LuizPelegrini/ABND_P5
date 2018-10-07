package com.example.android.abnd_p5;


import android.content.res.Resources;
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
public class HotelFragment extends Fragment {

    ArrayList<Hotel> hotels;

    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        Resources resources = getResources();

        hotels = new ArrayList<>();
        hotels.add(new Hotel(resources.getString(R.string.rendezvous_hotel), Hotel.Stars.FOUR, resources.getString(R.string.rendezvous_hotel_address), R.drawable.rendezvous_hotel));
        hotels.add(new Hotel(resources.getString(R.string.aqueen_hotel), Hotel.Stars.THREE, resources.getString(R.string.aqueen_hotel_address), R.drawable.aqueen_hotel_lavender));
        hotels.add(new Hotel(resources.getString(R.string.strand_hotel), Hotel.Stars.THREE, resources.getString(R.string.strand_hotel_address), R.drawable.strand_hotel));
        hotels.add(new Hotel(resources.getString(R.string.york_hotel), Hotel.Stars.FOUR, resources.getString(R.string.york_hotel_address), R.drawable.york_hotel));
        hotels.add(new Hotel(resources.getString(R.string.regent), Hotel.Stars.FIVE, resources.getString(R.string.regent_address), R.drawable.the_regent));
        hotels.add(new Hotel(resources.getString(R.string.marina_bay_sands_hotel), Hotel.Stars.FIVE, resources.getString(R.string.marina_bay_sands_hotel_address), R.drawable.marina_bay_sands));

        ListView listView = rootView.findViewById(R.id.list_view);
        HotelAdapter adapter = new HotelAdapter(getActivity(), hotels);
        listView.setAdapter(adapter);

        return rootView;
    }

}
