package com.example.homespace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListViewHolder> {
    private ArrayList<Item> itemList;

    public ListItemAdapter(ArrayList<Item> list){
        this.itemList = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_data, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.itemName.setText(item.getName());
        holder.itemName.setText(item.getQuantity());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, quantity;

        public ListViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.item_name);
            quantity = view.findViewById(R.id.quantity);
        }
    }
}
