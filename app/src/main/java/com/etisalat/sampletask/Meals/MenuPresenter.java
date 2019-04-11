package com.etisalat.sampletask.Meals;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.MainThread;
import android.util.Log;

import com.etisalat.sampletask.Meals.models.Item;
import com.etisalat.sampletask.Meals.models.MenuModel;
import com.etisalat.sampletask.Meals.usecases.MenuUseCase;
import com.etisalat.sampletask.bases.ApplicationClass;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.bases.BasePresenterListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MenuPresenter extends BasePresenter {
    private MenuUseCase menuUseCase;
    private ArrayList<Item> model;

    public MenuPresenter(BasePresenterListener listener) {
        super(listener);
        this.menuUseCase = new MenuUseCase();
         model=new ArrayList<Item>();
    }

    public ArrayList<Item> getMenuItems() {
        listener.showProgress();
        menuUseCase.getMenuItems()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MenuModel>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(MenuModel menuModel) {
                listener.addItems(menuUseCase.sortMenuItems(menuModel.getItem()));
                Date currentTime = Calendar.getInstance().getTime();
                setLastUpdateTime(currentTime.toString());
            }

            @Override
            public void onError(Throwable e) {
             Log.d("model",e.getMessage());
                listener.hideProgress();
            }

            @Override
            public void onComplete() {
                Log.d("model","complete");
                listener.hideProgress();
            }
        });

        return model;
    }

    private void setLastUpdateTime(String lastUpdate){
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("lastUpdatedTime", lastUpdate);
        editor.commit();
    }


}
