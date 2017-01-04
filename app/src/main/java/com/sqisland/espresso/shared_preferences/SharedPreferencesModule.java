package com.sqisland.espresso.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sqisland.espresso.shared_preferences.utils.PreferenceUtils;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = AndroidModule.class)
public class SharedPreferencesModule {
  @Provides
  @Singleton
  PreferenceUtils provideSharedPreferences(Context context) {
    return new PreferenceUtils(context);
  }
}