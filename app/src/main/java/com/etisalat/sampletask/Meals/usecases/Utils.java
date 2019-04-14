package com.etisalat.sampletask.Meals.usecases;

import com.etisalat.sampletask.Meals.models.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Utils {
    public static ArrayList<Item> sortMenuItems(ArrayList<Item> items){
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return items;
    }
}
