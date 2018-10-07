package com.example.android.abnd_p5;

class Restaurant {
    private String _name;           // The name of the restaurant
    private String _cuisineType;    // The type of food it serves
    private String _address;        // The address
    private int _imageResource;     // The restaurant image resource

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
