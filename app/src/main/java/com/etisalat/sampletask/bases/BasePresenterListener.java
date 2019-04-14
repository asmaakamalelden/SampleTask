package com.etisalat.sampletask.bases;

import com.etisalat.sampletask.Meals.models.Item;

import java.util.ArrayList;

public interface BasePresenterListener {
    void showProgress();
    void hideProgress();
    void addItems(ArrayList<Item> items);
}
