package com.etisalat.sampletask.Meals;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.etisalat.sampletask.Meals.models.Item;
import com.etisalat.sampletask.bases.BaseFragment;
import com.example.sampletask.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends BaseFragment<MenuPresenter> {

    @BindView(R.id.rvMenu)
    RecyclerView rv_Menu;
    LinearLayout baseView;
    MenuPresenter menuPresenter;
    MenuAdapter menuAdapter;
//    ArrayList<Item> items;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        menuPresenter = new MenuPresenter(this);
        baseView = (LinearLayout) inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this,baseView);
        super.onCreateView(inflater, container, savedInstanceState);

        return baseView;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    protected MenuPresenter setupPresenter() {
        return menuPresenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
     menuPresenter.getMenuItems();
        super.onActivityCreated(savedInstanceState);
        rv_Menu.setLayoutManager(new LinearLayoutManager(getActivity()));
        menuAdapter=new MenuAdapter();
        rv_Menu.setAdapter(menuAdapter);

    }

    @Override
    public void handelSnackbarVisibilty() {
        showSnackbar("connection problem",baseView);
    }

    @Override
    public void addItems(ArrayList<Item> items) {
        menuAdapter.setItems(items);
        menuAdapter.notifyDataSetChanged();
    }

}
