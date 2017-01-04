package com.sqisland.espresso.shared_preferences.utils;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;

/**
 * Created by nsmirosh on 3/15/2015.
 */
public class PreferenceUtils {

  private SharedPreferences mPrefs;

  public static final String PREFERENCES_KEY = "myPrefsKey";

  public static final String INT_LAST_VERSION_CODE_OF_UPGRADED_PREFS_KEY =
     "prefs_int_last_version_code_of_upgraded_prefs_key";
  public static final String BOOL_SMS_INTERCEPTION_KEY ="prefs_bool_sms_interception_key";
  public static final String BOOL_UPDATE_BUDGET_ONCE_A_DAY_KEY =
     "prefs_bool_update_budget_once_a_day_key";

  public static final String INT_PERIOD_START_DAY ="prefs_int_period_start_day_key";
  public static final String BOOLEAN_RETURNING_KEY = "prefs_boolean_returning_key";

  Context mContext;

  @Inject
  public PreferenceUtils(Context context) {
    this.mPrefs = context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
    this.mContext = context;
  }

  public void clearPreferences() {
    mPrefs.edit().clear().apply();
  }



  public int getPeriodStartDay() {
    return mPrefs.getInt(INT_PERIOD_START_DAY, 1);
  }
  //leave the functions because they have a different default value
  public boolean isSmsInterceptionEnabled() {
    return mPrefs.getBoolean(BOOL_SMS_INTERCEPTION_KEY, true);
  }
  //leave the functions because they have a different default value

  public boolean isBudgetUpdatedOnceADay() {
    return mPrefs.getBoolean(BOOL_UPDATE_BUDGET_ONCE_A_DAY_KEY, true);
  }

  public void setFloat(String key, float value) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putFloat(key, value);
    editor.apply();
  }

  public float getFloat(String key, float defaultValue) {
    return mPrefs.getFloat(key, defaultValue);
  }

  public void setInt(String key, int value) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putInt(key, value);
    editor.apply();
  }

  public int getInt(String key, int defaultValue) {
    return mPrefs.getInt(key, defaultValue);
  }

  public int getInt(String key) {
    return mPrefs.getInt(key, 0);
  }

  public void setLong(String key, long value) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putLong(key, value);
    editor.apply();
  }

  public long getLong(String key, long defaultValue) {

    return mPrefs.getLong(key, defaultValue);
  }

  public void setString(String key, String value) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putString(key, value);
    editor.apply();
  }

  public String getString(String key, String defaultValue) {
    return mPrefs.getString(key, defaultValue);
  }

  public String getString(String key) {
    return mPrefs.getString(key, null);
  }

  public void setBoolean(String key, boolean value) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putBoolean(key, value);
    editor.apply();
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    return mPrefs.getBoolean(key, defaultValue);
  }

  public boolean getBoolean(String key) {
    return mPrefs.getBoolean(key, false);
  }

  public void removeKey(String key) {
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.remove(key);
    editor.apply();
  }

  public boolean hasKey(String key) {
    return mPrefs.contains(key);
  }

  public enum KeyType {
    STRING, BOOLEAN, INTEGER, FLOAT, LONG
  }

  public void upgradeKey(String originalKey, String newKey, KeyType type) {
    SharedPreferences.Editor editor = mPrefs.edit();

    switch (type) {
      case STRING:
        String string = mPrefs.getString(originalKey, null);
        if (string != null) editor.putString(newKey, string);
        break;
      case INTEGER:
        int integer = mPrefs.getInt(originalKey, 0);
        if (integer != 0) editor.putInt(newKey, integer);
        break;
      case BOOLEAN:
        boolean bool = mPrefs.getBoolean(originalKey, false);
        if (bool) editor.putBoolean(newKey, true);
        break;
      case FLOAT:
        float Float = mPrefs.getFloat(originalKey, 0);
        if (Float != 0) editor.putFloat(newKey, Float);
        break;
      case LONG:
        long Long = mPrefs.getLong(originalKey, 0);
        if (Long != 0) editor.putLong(newKey, Long);
        break;
    }

    editor.remove(originalKey);
    editor.apply();
  }

  public void removeKeys(String[] keys) {
    SharedPreferences.Editor editor = mPrefs.edit();
    for (String key : keys) {
      if (mPrefs.contains(key)) {
        editor.remove(key);
      }
    }
    editor.apply();
  }
}
