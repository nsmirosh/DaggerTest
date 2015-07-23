package com.sqisland.espresso.shared_preferences;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MockSharedPreferencesModule.class)
public interface TestComponent extends DemoComponent {
  void inject(MainActivityTest mainActivityTest);
}