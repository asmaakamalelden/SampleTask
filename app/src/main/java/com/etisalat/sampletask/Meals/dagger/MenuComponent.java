package com.etisalat.sampletask.Meals.dagger;

import com.etisalat.sampletask.Meals.models.MenuModel;
import com.etisalat.sampletask.Meals.usecases.MenuUseCase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules =MenuModule.class)
public interface MenuComponent {
    void inject(MenuUseCase menuUseCase);

class Initializer {

    private static MenuComponent component;

    public static MenuComponent buildComponent() {
        if (component == null) {
          component=DaggerMenuComponent.builder().build();
        }
        return component;
    }
}
}