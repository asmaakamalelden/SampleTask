package com.etisalat.sampletask.Meals.usecases;

import com.etisalat.sampletask.Meals.models.Item;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void sortMenuItems() {
        ArrayList<Item> items=new ArrayList<Item>();
        ArrayList<Item> expect=new ArrayList<Item>();

        Item item1=new Item();
        Item item2=new Item();
        item1.setId("1");
        item1.setName("aaaa");
        item1.setDescription("Desc1");
        item2.setId("2");
        item2.setName("bbbbb");
        item2.setDescription("Desc2");

        items.add(item2);
        items.add(item1);

        expect.add(item1);
        expect.add(item2);

        ArrayList<Item> result= Utils.sortMenuItems(items);

        Assert.assertEquals(expect,result);
    }
}