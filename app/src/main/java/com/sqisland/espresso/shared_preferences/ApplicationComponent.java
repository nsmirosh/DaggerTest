package com.sqisland.espresso.shared_preferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    AndroidModule.class,
    SharedPreferencesModule.class
})
public interface ApplicationComponent extends DemoComponent {
}