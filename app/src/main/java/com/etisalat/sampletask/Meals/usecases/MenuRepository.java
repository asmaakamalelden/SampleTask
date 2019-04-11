package com.etisalat.sampletask.Meals.usecases;

import com.etisalat.sampletask.Meals.models.MenuModel;

import io.reactivex.Observable;

public class MenuRepository {
    private MenuApis menuApis;

    public MenuRepository() {
        menuApis= APIClient.getClient().create(MenuApis.class);

    }

    public Observable<MenuModel> getMenuItems() {

        return menuApis.getMenuItems();
    }
}
