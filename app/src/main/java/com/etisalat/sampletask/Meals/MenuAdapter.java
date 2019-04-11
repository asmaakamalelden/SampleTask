package com.etisalat.sampletask.Meals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etisalat.sampletask.Meals.models.Item;
import com.example.sampletask.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    ArrayList<Item> items;

    public MenuAdapter() {
       items=new ArrayList<Item>();
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View menuView = inflater.inflate(R.layout.menu_items_layout, null, false);
        MenuHolder menuHolder = new MenuHolder(menuView);
        return menuHolder;
    }

    public void setItems(ArrayList<Item>  listitem){
        items=listitem;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder menuHolder, int position) {
        Log.d("meal", items.get(1).getDescription());
        menuHolder.tv_Price.setText(items.get(position).getCost());
        menuHolder.tv_Description.setText(items.get(position).getDescription());
        menuHolder.tv_Name.setText(items.get(position).getName());
    }

    public class MenuHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPrice)
        public TextView tv_Price;
        @BindView(R.id.tvDesccription)
        TextView tv_Description;
        @BindView(R.id.tvName)
        TextView tv_Name;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
