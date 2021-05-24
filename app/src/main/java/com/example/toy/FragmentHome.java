package com.example.toy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ArrayList<RecyclerBannerItem> bannerItems = new ArrayList<>();
    RecyclerBannerAdapter bannerAdapter;
    RecyclerView banner;

    ArrayList<RecyclerListItem> listItems = new ArrayList<>();
    RecyclerListAdapter listAdapter;
    RecyclerView list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        banner = view.findViewById(R.id.recycler_banner);
        bannerAdapter = new RecyclerBannerAdapter(getActivity(),bannerItems);
        banner.setAdapter(bannerAdapter);

        loadData();

        list = view.findViewById(R.id.list);
        listAdapter = new RecyclerListAdapter(getActivity(),listItems);
        list.setAdapter(listAdapter);

        list();


    }

    void loadData(){
        bannerItems.add(new RecyclerBannerItem(R.drawable.baner_all));
        bannerItems.add(new RecyclerBannerItem(R.drawable.baner_all));
        bannerItems.add(new RecyclerBannerItem(R.drawable.baner_all));
        bannerItems.add(new RecyclerBannerItem(R.drawable.baner_all));
        bannerItems.add(new RecyclerBannerItem(R.drawable.baner_all));
    }

    void list(){
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
    }

}
