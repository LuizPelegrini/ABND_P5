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

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(@NonNull Context context, @NonNull List<Restaurant> objects) {
        super(context, 0, objects);
    }

    // ViewHolder design pattern for better performance and to remove unnecessary findViewById calls
    static class ViewHolder
    {
        ImageView restaurantImageView;
        TextView cuisineTextView;
        TextView addressTextView;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant restaurant = getItem(position);
        ViewHolder holder;

        // This is true only if there is no available view to be recycled
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_item, parent, false);

            holder.restaurantImageView = convertView.findViewById(R.id.restaurant_image_view);
            holder.cuisineTextView = convertView.findViewById(R.id.cuisine_data_text_view);
            holder.addressTextView = convertView.findViewById(R.id.address_data_text_view);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        // Fill UI with restaurant data
        holder.restaurantImageView.setImageResource(restaurant.getImageResource());
        holder.cuisineTextView.setText(restaurant.getCuisineType());
        holder.addressTextView.setText(restaurant.getAddress());

        return convertView;
    }
}
