package com.example.gifapplication.service;


import com.example.gifapplication.model.trending.ItemTrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GIFRepository
{
    @GET("v1/trending?key=LIVDSRZULELA&limit=20")
    Call<ItemTrendingResponse> getItemTrending();
}
