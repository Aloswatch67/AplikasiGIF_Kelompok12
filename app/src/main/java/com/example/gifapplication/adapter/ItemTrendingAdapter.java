package com.example.gifapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gifapplication.R;
import com.example.gifapplication.model.trending.ItemTrendingResultsItem;

import java.util.ArrayList;

public class ItemTrendingAdapter extends RecyclerView.Adapter<ItemTrendingAdapter.ViewHolder>
{
    private ArrayList<ItemTrendingResultsItem> itemTrendingResultsItems = new ArrayList<>();
    private Context context;

    private static String BASE_GIF_URL = "https://media.tenor.com/images/d540801f24d6b6913a22831e55f42fe8/tenor.gif";

    public ItemTrendingAdapter(Context context)
    {
        this.context = context;
    }

    public void setData(ArrayList<ItemTrendingResultsItem> items)
    {
        itemTrendingResultsItems.clear();
        itemTrendingResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemTrendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTrendingAdapter.ViewHolder holder, int position)
    {
        Glide.with(context).load(BASE_GIF_URL)
                .into(holder.viewgif);
    }

    @Override
    public int getItemCount()
    {
        return itemTrendingResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView viewgif;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            viewgif = itemView.findViewById(R.id.itemlist_view);
        }
    }
}
