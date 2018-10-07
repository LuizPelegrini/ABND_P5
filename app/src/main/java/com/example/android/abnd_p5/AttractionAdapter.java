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

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    // ViewHolder design pattern for better performance and to remove unnecessary findViewById calls
    static class ViewHolder
    {
        ImageView attractionImageView;
        TextView attractionNameTextView;
    }

    public AttractionAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Attraction attraction = getItem(position);
        ViewHolder holder;

        // This is true only if there is no available view to be recycled
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_item, parent, false);

            holder.attractionImageView = convertView.findViewById(R.id.attraction_image);
            holder.attractionNameTextView = convertView.findViewById(R.id.attraction_name_text_view);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        // Fill UI with attraction data
        holder.attractionImageView.setImageResource(attraction.getImageResource());
        holder.attractionNameTextView.setText(attraction.getName());

        return convertView;
    }
}
