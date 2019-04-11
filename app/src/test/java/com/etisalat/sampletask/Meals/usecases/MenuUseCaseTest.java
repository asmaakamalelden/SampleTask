package com.etisalat.sampletask.Meals.usecases;

import com.etisalat.sampletask.Meals.models.Item;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuUseCaseTest {

    @Test
    public void sortMenuItems() {
        ArrayList<Item> items=new ArrayList<Item>();
        ArrayList<Item> expect=new ArrayList<Item>();

        Item item=new Item();
        item.setId("1");
        item.setName("aaaa");
        item.setDescription("Desc1");
        Item item2=new Item();
        item2.setId("2");
        item2.setName("bbbbb");
        item2.setDescription("Desc2");
        items.add(item2);


        expect.add(item2);
        expect.add(item);



        MenuUseCase menuUseCase=new MenuUseCase();
        ArrayList<Item> result= menuUseCase.sortMenuItems(items);

       Assert.assertEquals(expect,result);
    }
}