package com.example.armin.sqllitetest;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Armin on 2017-04-12.
 */

public class ListDataActivity extends AppCompatActivity {

    public static final String TAG = "ListDataActivity";
    @BindView(R.id.mListView)
    ListView mListView;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listt_layout);
        ButterKnife.bind(this);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<RowModel> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(new RowModel(data.getString(1), data.getString(2), data.getString(3)));
        }

        ListDataAdapter adapter = new ListDataAdapter(this, R.layout.adapter_view_layout, listData);
        mListView.setAdapter(adapter);
    }



        //ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        //listView.setAdapter(listAdapter);

    }

