package com.example.android.abnd_p5;


import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhraseFragment extends Fragment {

    private ArrayList<Phrase> phrases;
    private MediaPlayer mediaPlayer;
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;


    public PhraseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);
        createAudioFocusRequestObject();
        // Add some data to the list
        phrases = new ArrayList<>();
//        phrases.add(new Phrase("Chinese A", "English A", R.raw.));
//        phrases.add(new Phrase("Chinese B", "English B", R.raw.));
//        phrases.add(new Phrase("Chinese C", "English C", R.raw.));
//        phrases.add(new Phrase("Chinese D", "English D", R.raw.));
//        phrases.add(new Phrase("Chinese E", "English E", R.raw.));
//        phrases.add(new Phrase("Chinese F", "English F", R.raw.));

        // Setup the list
        ListView listView = rootView.findViewById(R.id.list_view);
        PhraseAdapter adapter = new PhraseAdapter(getActivity(), phrases);
        listView.setAdapter(adapter);

        // Config clicks for each item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // release any possible resources before start playing a new audio
                releaseMediaPlayer();

                // Request focus (differently depending on the API level)
                int res;
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    res = audioManager.requestAudioFocus(audioFocusRequest);
                else
                    res = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                // If the focus has been successfully granted, then start playing and let the listener knows when the audio finishes playing
                if(res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), phrases.get(position).getAudioResource());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });

        return rootView;
    }

    // Create the audio focus request object. This is needed for Android Oreo
    private void createAudioFocusRequestObject()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AudioAttributes audioAttributes;

            // Build audio attributes to later provide to the audioFocusRequest object
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build();

            // Build audioFocusRequest to later provide to the requestAudioFocus method of the AudioManager
            audioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                    .setAudioAttributes(audioAttributes)
                    .setAcceptsDelayedFocusGain(true)
                    .setOnAudioFocusChangeListener(onAudioFocusChangeListener)
                    .build();
        }
    }

    // This listener is responsible to track the audio focus state changes
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch(focusChange)
            {
                // If the focus has been gained, set the audio to the start and play it
                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                    break;
                // If the focus has been lost, release the media player resources
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
                // If the focus has been temporarily lost or ducked, then pause the audio
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mediaPlayer.pause();
                    break;

            }
        }
    };

    // This listener is responsible to track when the audio is completed
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    // Releases the resources used by the media player object
    private void releaseMediaPlayer()
    {
        if(mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();

            mediaPlayer.release();

            mediaPlayer = null;

            // Abandons the audio focus
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            else
                audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    // When the Fragment is stopped, release the media player as well
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

}
