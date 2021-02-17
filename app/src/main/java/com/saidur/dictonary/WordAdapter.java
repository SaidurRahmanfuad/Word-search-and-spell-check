package com.saidur.dictonary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder> {
    ArrayList<WordItem> wordItemArrayList=new ArrayList<>();
    Context c;

    public WordAdapter(ArrayList<WordItem> wordItemArrayList, Context c) {
        this.wordItemArrayList = wordItemArrayList;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(c).inflate(R.layout.rec_item,parent,false);
       MyViewHolder mvh=new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WordItem word=wordItemArrayList.get(position);
        holder.worditem.setText(word.getItem());

    }


    @Override
    public int getItemCount() {
        return wordItemArrayList.size();
    }

    public void filterListFun(ArrayList<WordItem> wordFilterItem)
    {
        wordItemArrayList=wordFilterItem;
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView worditem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            worditem=itemView.findViewById(R.id.wordItem);
        }
    }
}
