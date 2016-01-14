package com.sqisland.espresso.shared_preferences;

public class MockDemoApplication extends DemoApplication {
  protected DemoComponent createComponent() {
    return DaggerTestComponent.builder()
        .mockSharedPreferencesModule(new MockSharedPreferencesModule())
        .build();
  }
}