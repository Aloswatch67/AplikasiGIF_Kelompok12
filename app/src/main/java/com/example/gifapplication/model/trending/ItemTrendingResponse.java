package com.example.gifapplication.model.trending;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemTrendingResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("results")
	private ArrayList<ItemTrendingResultsItem> results;

	public String getNext(){
		return next;
	}

	public ArrayList<ItemTrendingResultsItem> getResults(){
		return results;
	}
}