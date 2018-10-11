package com.example.android.abnd_p5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context _context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this._context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new RestaurantFragment();
            case 1:
                return new AttractionsFragment();
            case 2:
                return new HotelFragment();
            case 3:
                return new PhraseFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return _context.getResources().getString(R.string.restaurants);
            case 1:
                return _context.getResources().getString(R.string.attractions);
            case 2:
                return _context.getResources().getString(R.string.hotels);
            case 3:
                return _context.getResources().getString(R.string.phrases);
            default:
                return "";
        }
    }
}
