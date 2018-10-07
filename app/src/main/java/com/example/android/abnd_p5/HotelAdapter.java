package com.example.android.abnd_p5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    // ViewHolder design pattern for better performance and to remove unnecessary findViewById calls
    static class ViewHolder
    {
        ImageView hotelImageView;
        TextView hotelNameTextView;
        ImageView starsImageView;
        TextView addressTextView;
    }

    public HotelAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hotel hotel = getItem(position);
        ViewHolder holder;

        // This is true only if there is no available view to be recycled
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_item, parent, false);

            holder.hotelImageView = convertView.findViewById(R.id.hotel_image_view);
            holder.hotelNameTextView = convertView.findViewById(R.id.hotel_name_text_view);
            holder.starsImageView = convertView.findViewById(R.id.hotel_stars_image_view);
            holder.addressTextView = convertView.findViewById(R.id.hotel_address_text_view);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        // Fill UI with hotel data
        holder.hotelImageView.setImageResource(hotel.getImageResource());
        holder.hotelNameTextView.setText(hotel.getName());
        holder.starsImageView.setImageResource(hotel.getStars());
        holder.addressTextView.setText(hotel.getAddress());

        return convertView;
    }
}
