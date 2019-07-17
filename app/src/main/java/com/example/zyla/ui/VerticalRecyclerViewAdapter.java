package com.example.zyla.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zyla.Model.Artist;
import com.example.zyla.R;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalViewHolder> {
    int viewCount = 2;
    ArrayList<Artist> list = new ArrayList<>();
    Context context;
    public VerticalRecyclerViewAdapter(ArrayList<Artist> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);
        return new VerticalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.horizontalAdapter.setViewCount(viewCount);
        LinearLayoutManager llm = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.horizontalRecyclerView.setLayoutManager(llm);
        holder.horizontalRecyclerView.setHasFixedSize(true);
        holder.horizontalRecyclerView.setAdapter(holder.horizontalAdapter);
        holder.horizontalAdapter.refreshHorizontalData(list.get(position));
        holder.setArtist(list.get(position).getName());
    }

    public void refreshVerticalView(int count) {
        viewCount = count;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RecyclerView horizontalRecyclerView;
        HorizontalAdapter horizontalAdapter;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_recycler);
            horizontalAdapter = new HorizontalAdapter(context);
        }

        public void setArtist(String artist) {
            textView.setText(artist);
        }
    }
}


