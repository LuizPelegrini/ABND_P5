package com.example.android.abnd_p5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PhraseAdapter extends ArrayAdapter<Phrase> {

    // ViewHolder design pattern for better performance and to remove unnecessary findViewById calls
    static class ViewHolder
    {
        TextView chineseTextView;
        TextView englishTextView;
    }


    public PhraseAdapter(@NonNull Context context, @NonNull List<Phrase> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Phrase phrase = getItem(position);
        ViewHolder holder;

        // This is true only if there is no available view to be recycled
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_item, parent, false);

            holder.chineseTextView = convertView.findViewById(R.id.chinese_text_view);
            holder.englishTextView = convertView.findViewById(R.id.english_text_view);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        // Fill UI with phrase data
        holder.chineseTextView.setText(phrase.getChinesePhrase());
        holder.englishTextView.setText(phrase.getEnglishTranslation());

        return convertView;
    }
}
