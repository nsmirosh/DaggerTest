package com.sqisland.espresso.shared_preferences;

import android.app.Application;

public class DemoApplication extends Application {
  private final DemoComponent component = createComponent();

  protected DemoComponent createComponent() {
    return DaggerApplicationComponent.builder()
        .androidModule(new AndroidModule(this))
        .sharedPreferencesModule(new SharedPreferencesModule())
        .build();
  }

  public DemoComponent component() {
    return component;
  }
}