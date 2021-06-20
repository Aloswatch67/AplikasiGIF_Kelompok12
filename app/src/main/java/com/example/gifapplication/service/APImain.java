package com.example.gifapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APImain
{
    private Retrofit retrofit;

    public GIFRepository getAPIgif()
    {
        String BASE_URL = "https://api.tenor.com/";
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(GIFRepository.class);
    }
}
