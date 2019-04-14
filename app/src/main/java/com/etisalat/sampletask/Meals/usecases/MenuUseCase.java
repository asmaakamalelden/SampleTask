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
}
