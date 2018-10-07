package com.example.android.abnd_p5;

public class Attraction {
    private String _name;           // The name of the attraction
    private int _imageResource;     // The attraction image

    public Attraction(String name, int imageResource)
    {
        this._name = name;
        this._imageResource = imageResource;
    }

    public String getName() {
        return _name;
    }

    public int getImageResource() {
        return _imageResource;
    }
}
