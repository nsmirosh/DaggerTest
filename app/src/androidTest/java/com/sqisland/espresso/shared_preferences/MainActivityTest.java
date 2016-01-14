package com.sqisland.espresso.shared_preferences;

import android.app.Instrumentation;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
  @Inject
  SharedPreferences preferences;

  @Rule
  public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
      MainActivity.class,
      true,     // initialTouchMode
      false);   // launchActivity. False so we set up the preferences before activity launch

  @Before
  public void setUp() {
    Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    DemoApplication app
        = (DemoApplication) instrumentation.getTargetContext().getApplicationContext();
    TestComponent component = (TestComponent) app.component();
    component.inject(this);

    SharedPreferences.Editor editor = preferences.edit();
    editor.clear();
    editor.apply();
  }

  @Test
  public void firstTime() {
    activityRule.launchActivity(null);
    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.hello_stranger)));
  }

  @Test
  public void returning() {
    SharedPreferences.Editor editor = preferences.edit();
    editor.putBoolean(MainActivity.KEY_RETURNING, true);
    editor.apply();

    activityRule.launchActivity(null);

    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.welcome_back)));
  }
}