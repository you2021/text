package com.example.toy;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {

    @GET("/Test")
    Call<String> getJsonString();

    @FormUrlEncoded
    @POST("/cosmeticsListName")
    Call<String> getBoardArray(@Field("index") int index);
}
