package com.example.toy;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
    }


    public void clickBtn(View view) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://randombox.site/");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        Retrofit retrofit =builder.build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
//        Call<String> call = retrofitService.getJsonString();
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String s = response.body();
//                tv.setText(s);
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                tv.setText("error : "+t.getMessage());
//                Log.i("log",t.getMessage());
//            }
//        });

        Call<String> call = retrofitService.getBoardArray(0);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tv.setText(response.body());
                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
            }
        });


    }
}