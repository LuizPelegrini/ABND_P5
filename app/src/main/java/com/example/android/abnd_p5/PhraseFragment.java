package com.example.android.abnd_p5;


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
public class PhraseFragment extends Fragment {

    ArrayList<Phrase> phrases;

    public PhraseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        phrases = new ArrayList<>();
//        phrases.add(new Phrase("Chinese A", "English A", R.raw.));
//        phrases.add(new Phrase("Chinese B", "English B", R.raw.));
//        phrases.add(new Phrase("Chinese C", "English C", R.raw.));
//        phrases.add(new Phrase("Chinese D", "English D", R.raw.));
//        phrases.add(new Phrase("Chinese E", "English E", R.raw.));
//        phrases.add(new Phrase("Chinese F", "English F", R.raw.));

        phrases.add(new Phrase("Chinese B", "English B", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese C", "English C", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese D", "English D", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese E", "English E", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese F", "English F", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese B", "English B", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese C", "English C", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese D", "English D", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese E", "English E", R.drawable.ic_launcher_background));
        phrases.add(new Phrase("Chinese F", "English F", R.drawable.ic_launcher_background));

        ListView listView = rootView.findViewById(R.id.list_view);
        PhraseAdapter adapter = new PhraseAdapter(getActivity(), phrases);
        listView.setAdapter(adapter);

        return rootView;
    }

}
