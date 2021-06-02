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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ArrayList<RecyclerListItem> listItems = new ArrayList<>();
    RecyclerListAdapter listAdapter;
    RecyclerView list;

    AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
           @Override
           public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

           }
       });

       mAdView = view.findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       mAdView.loadAd(adRequest);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);





        list = view.findViewById(R.id.list);
        listAdapter = new RecyclerListAdapter(getActivity(),listItems);
        list.setAdapter(listAdapter);

        list();


    }

    void list(){
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
        listItems.add(new RecyclerListItem());
    }

}
