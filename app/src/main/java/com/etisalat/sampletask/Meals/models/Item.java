package com.etisalat.sampletask.Meals.models;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class Item
{
    @Element(name="cost",required = false)
    private String cost;
    @Element(name="name",required = false)
    private String name;
    @Element(name="description",required = false)
    private String description;
    @Element(name="id",required = false)
    private String id;

    public String getCost ()
    {
        return cost;
    }

    public void setCost (String cost)
    {
        this.cost = cost;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }
}

