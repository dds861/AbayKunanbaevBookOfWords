package com.injuryrecovery.hi.abaykunanbaevblackwords;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dds86 on 14.09.2017.
 */

public class MyAdapter extends ArrayAdapter<Product> {
    private List<Product> objects;

    public MyAdapter(@NonNull Context context, @NonNull List<Product> objects) {
        super(context, 0, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);

        Product product = getItem(position);

        TextView textView1 = (TextView) view.findViewById(R.id.text1);
        textView1.setText(product.getTextView1());

        return view;
    }
}