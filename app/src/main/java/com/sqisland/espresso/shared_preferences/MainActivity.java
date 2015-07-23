package com.sqisland.espresso.shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends Activity {
  static final String KEY_RETURNING = "returning";

  @Inject
  SharedPreferences preferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((DemoApplication) getApplication()).component().inject(this);

    boolean returning = preferences.getBoolean(KEY_RETURNING, false);
    if (!returning) {
      SharedPreferences.Editor editor = preferences.edit();
      editor.putBoolean(KEY_RETURNING, true);
      editor.apply();
    }

    TextView textView = (TextView) findViewById(R.id.greeting);
    textView.setText(returning ? R.string.welcome_back : R.string.hello_stranger);
  }
}