package com.etisalat.sampletask.Meals.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "menu")
public class MenuModel {
    @ElementList(entry="item", inline=true)
        private ArrayList<Item> item;

        public ArrayList<Item> getItem ()
        {
            return item;
        }

        public void setItem (ArrayList<Item> item)
        {
            this.item = item;
        }
}
