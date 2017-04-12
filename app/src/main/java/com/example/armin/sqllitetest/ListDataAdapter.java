package com.example.armin.sqllitetest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Armin on 2017-04-12.
 */

class ListDataAdapter extends ArrayAdapter<RowModel> {

private static final String TAG = "ListDataAdapter";
    private Context mContext;
    int mResource;

    public ListDataAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<RowModel> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RowModel model = getItem(position);
        String name = model.getOne();
        String sex = model.getTwo();
        String date = model.getThree();



        LayoutInflater inflater =  LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent, false);


        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvSex = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvDate = (TextView) convertView.findViewById(R.id.textView3);

        tvName.setText(name);
        tvDate.setText(date);
        tvSex.setText(sex);

        return convertView;
    }
}
