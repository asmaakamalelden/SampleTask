package com.etisalat.sampletask.Meals.usecases;

import android.content.Context;
import android.util.Log;

import com.etisalat.sampletask.bases.ApplicationClass;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static android.content.ContentValues.TAG;

public class APIClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
        Cache cache = new Cache(cacheDir, 10 * 1024 * 1024);


        OkHttpClient httpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(chain -> {
                    try {
                        return chain.proceed(chain.request());
                    } catch (Exception e) {
                        Request offlineRequest = chain.request().newBuilder()
                                .header("Cache-Control", "public, only-if-cached," +
                                        "max-stale=" + 60 * 60 * 24)
                                .build();
                        return chain.proceed(offlineRequest);
                    }
                })
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/pizza/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(Injector.provideOkHttpClient())
                .build();



        return retrofit;
    }

}
