package com.etisalat.sampletask.Meals.usecases;

import com.etisalat.sampletask.Meals.models.MenuModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MenuApis {
    @GET("?format=xml")
    @Headers({"Accept: application/xml",
            "User-Agent: Retrofit-Sample-App"})
    Observable<MenuModel> getMenuItems();
}
