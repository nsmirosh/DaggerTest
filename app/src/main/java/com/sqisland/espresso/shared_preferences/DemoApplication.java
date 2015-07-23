package com.sqisland.espresso.shared_preferences;

import android.app.Application;

public class DemoApplication extends Application {
  private DemoComponent component = null;

  @Override public void onCreate() {
    super.onCreate();
    if (component == null) {
      component = DaggerApplicationComponent.builder()
          .androidModule(new AndroidModule(this))
          .sharedPreferencesModule(new SharedPreferencesModule())
          .build();
    }
  }

  public void setComponent(DemoComponent component) {
    this.component = component;
  }

  public DemoComponent component() {
    return component;
  }
}