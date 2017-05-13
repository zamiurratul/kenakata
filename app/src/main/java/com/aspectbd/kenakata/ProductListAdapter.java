package com.aspectbd.kenakata;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductListAdapter extends ArrayAdapter<Product> {

    private List<Product> productList;

    public ProductListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        productList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.nameText);
        nameTextView.setText(productList.get(position).getName());

        TextView priceTextView = (TextView) convertView.findViewById(R.id.priceText);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("bn", "BD"));
        priceTextView.setText(formatter.format(productList.get(position).getPrice()));

        return convertView;
    }
}
