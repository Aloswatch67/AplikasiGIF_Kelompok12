package com.example.gifapplication.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gifapplication.model.trending.ItemTrendingResponse;
import com.example.gifapplication.model.trending.ItemTrendingResultsItem;
import com.example.gifapplication.service.APImain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GifViewModel extends ViewModel
{
    private APImain apimain;

    private MutableLiveData<ArrayList<ItemTrendingResultsItem>> listGIF = new MutableLiveData<>();

    public void setGif()
    {
        if (this.apimain == null)
        {
            apimain = new APImain();
        }

        apimain.getAPIgif().getItemTrending().enqueue(new Callback<ItemTrendingResponse>() {
            @Override
            public void onResponse(Call<ItemTrendingResponse> call, Response<ItemTrendingResponse> response)
            {
                ItemTrendingResponse responseItem = response.body();
                if (responseItem != null && responseItem.getResults() != null)
                {
                    ArrayList<ItemTrendingResultsItem> itemTrendingItems = responseItem.getResults();
                    listGIF.postValue(itemTrendingItems);
                }
            }

            @Override
            public void onFailure(Call<ItemTrendingResponse> call, Throwable t)
            {

            }
        });
    }

    public LiveData<ArrayList<ItemTrendingResultsItem>> getGIF()
    {
        return listGIF;
    }
}
