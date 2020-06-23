package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dds86 on 14.09.2017.
 */

class MyAdapter extends ArrayAdapter<Product> {


    public MyAdapter(@NonNull Context context, List<Product> items) {
        super(context, 0,items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);

        Product product = getItem(position);

        TextView textView1 = view.findViewById(R.id.text1);
            textView1.setText(product.getTextView1());
        return view;
    }
}