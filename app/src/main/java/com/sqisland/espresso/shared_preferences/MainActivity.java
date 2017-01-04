package com.sqisland.espresso.shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.sqisland.espresso.shared_preferences.utils.PreferenceUtils;
import javax.inject.Inject;

import static com.sqisland.espresso.shared_preferences.utils.PreferenceUtils.BOOLEAN_RETURNING_KEY;

public class MainActivity extends Activity {

  @Inject PreferenceUtils mPreferenceUtils;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((DemoApplication) getApplication()).component().inject(this);

    boolean returning = mPreferenceUtils.getBoolean(BOOLEAN_RETURNING_KEY);
    if (!returning) {
      mPreferenceUtils.setBoolean(BOOLEAN_RETURNING_KEY, true);
    }

    TextView textView = (TextView) findViewById(R.id.greeting);
    textView.setText(returning ? R.string.welcome_back : R.string.hello_stranger);
  }
}