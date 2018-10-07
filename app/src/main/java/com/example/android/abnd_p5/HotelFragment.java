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
public class HotelFragment extends Fragment {

    ArrayList<Hotel> hotels;

    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        hotels = new ArrayList<>();
        hotels.add(new Hotel("Hotel A", Hotel.Stars.THREE, "Address A", R.drawable.ic_launcher_background));
        hotels.add(new Hotel("Hotel B", Hotel.Stars.FIVE, "Address B", R.drawable.ic_launcher_background));
        hotels.add(new Hotel("Hotel C", Hotel.Stars.ONE, "Address C", R.drawable.ic_launcher_background));
        hotels.add(new Hotel("Hotel D", Hotel.Stars.TWO, "Address D", R.drawable.ic_launcher_background));
        hotels.add(new Hotel("Hotel E", Hotel.Stars.THREE, "Address E", R.drawable.ic_launcher_background));
        hotels.add(new Hotel("Hotel F", Hotel.Stars.FIVE, "Address F", R.drawable.ic_launcher_background));

        ListView listView = rootView.findViewById(R.id.list_view);
        HotelAdapter adapter = new HotelAdapter(getActivity(), hotels);
        listView.setAdapter(adapter);

        return rootView;
    }

}
