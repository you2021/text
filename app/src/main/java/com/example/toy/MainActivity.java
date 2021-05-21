package com.example.toy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RecyclerListDetailItem> items = new ArrayList<>();
    RecyclerListDetailAdapter adapter;
    RecyclerView recycler;

    ArrayList<RecyclerListItem> listItems = new ArrayList<>();
    RecyclerListAdapter listAdapter;
    RecyclerView listRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler_banner);
        adapter = new RecyclerListDetailAdapter(this,items);
        recycler.setAdapter(adapter);

        listRecycler = findViewById(R.id.list);
        listAdapter = new RecyclerListAdapter(this, listItems);
        listRecycler.setAdapter(listAdapter);

        Data();
        list();

    }

    void Data(){

        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
        items.add(new RecyclerListDetailItem());
    }

    void list(){
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());

    }

    public void clickBanner(View view) {
    }
}