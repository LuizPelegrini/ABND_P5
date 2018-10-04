package com.example.android.abnd_p5;

class Restaurant {
    private String _name;
    private String _cuisineType;
    private String _address;
    private int _imageResource;

    public Restaurant(String name, String cuisineType, String address, int imageResource)
    {
        this._name = name;
        this._cuisineType = cuisineType;
        this._address = address;
        this._imageResource = imageResource;
    }

    /// GETTERS
    public String getName() {
        return _name;
    }

    public String getCuisineType() {
        return _cuisineType;
    }

    public String getAddress() {
        return _address;
    }

    public int getImageResource() {
        return _imageResource;
    }
}
