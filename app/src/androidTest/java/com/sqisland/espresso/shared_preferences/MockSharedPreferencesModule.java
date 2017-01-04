package com.sqisland.espresso.shared_preferences;

import android.content.SharedPreferences;

import com.sqisland.espresso.shared_preferences.utils.PreferenceUtils;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

@Module
public class MockSharedPreferencesModule {

  @Provides
  @Singleton
  PreferenceUtils provideSharedPreferences() {
    return Mockito.mock(PreferenceUtils.class);
  }
}