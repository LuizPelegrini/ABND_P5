package com.example.android.abnd_p5;

public class Hotel {

    public enum Stars
    {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }

    private String _name;       // The name of the hotel
    private Stars _stars;       // The number of stars
    private String _address;    // The address
    private int _imageResource; // The hotel image resource

    public Hotel(String name, Stars stars, String address, int imageResource)
    {
        this._name = name;
        this._stars = stars;
        this._address= address;
        this._imageResource = imageResource;
    }

    public String getName() {
        return _name;
    }

    public int getStars() {

        return R.drawable.ic_launcher_background;

//        switch (this._stars)
//        {
//            case ONE:
//                return R.drawable.one_star;
//            case TWO:
//                return R.drawable.two_star;
//            case THREE:
//                return R.drawable.three_star;
//            case FOUR:
//                return R.drawable.four_star;
//            case FIVE:
//                return R.drawable.five_star;
//            default:
//                return R.drawable.one_star;
//        }
    }

    public String getAddress() {
        return _address;
    }

    public int getImageResource() {
        return _imageResource;
    }
}
