package com.etisalat.sampletask.Meals.usecases;


import android.content.Context;
import android.util.Log;

import com.etisalat.sampletask.Meals.dagger.DaggerMenuComponent;
import com.etisalat.sampletask.Meals.models.Item;
import com.etisalat.sampletask.Meals.models.MenuModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MenuUseCase {
    @Inject
     MenuRepository menuRepository;

    public MenuUseCase(){
      DaggerMenuComponent.Initializer.buildComponent().inject(this);

    }

    public Observable<MenuModel> getMenuItems(){
        Log.d("modelRepo",menuRepository.getMenuItems().toString());
        return menuRepository.getMenuItems();
    }

    public ArrayList<Item> sortMenuItems(ArrayList<Item> items){

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return items;
    }
}
