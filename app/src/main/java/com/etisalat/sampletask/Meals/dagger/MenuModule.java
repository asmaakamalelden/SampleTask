package com.etisalat.sampletask.Meals.dagger;

import com.etisalat.sampletask.Meals.usecases.MenuRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class MenuModule {
    @Provides @Singleton
    MenuRepository provideMenuRepository() {
        return new MenuRepository();
    }
}
