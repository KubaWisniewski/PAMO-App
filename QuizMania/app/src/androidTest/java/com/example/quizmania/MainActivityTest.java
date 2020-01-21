package com.example.quizmania;

import androidx.test.espresso.ViewInteraction;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void Activity_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.main_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Title_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.welcome_text_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Login_Button_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.login_button)).check(matches(isDisplayed()));
        onView(withId(R.id.login_button)).check(matches(isClickable()));
        onView(withId(R.id.login_button)).check(matches(withText(R.string.login_button_text)));
    }

    @Test
    public void Register_Button_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.register_button)).check(matches(isDisplayed()));
        onView(withId(R.id.register_button)).check(matches(isClickable()));
        onView(withId(R.id.register_button)).check(matches(withText(R.string.register_button_text)));
    }

    @Test
    public void Click_On_Login_Button_Should_Display_Login_Activity_In_View_Test() {
        ViewInteraction loginButton = onView(withId(R.id.login_button));
        loginButton.check(matches(isDisplayed()));
        loginButton.check(matches(isClickable()));
        loginButton.perform(click());
        onView(withId(R.id.login_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Click_On_Register_Button_Should_Display_Register_Activity_In_View_Test() {
        ViewInteraction registerButton = onView(withId(R.id.register_button));
        registerButton.check(matches(isDisplayed()));
        registerButton.check(matches(isClickable()));
        registerButton.perform(click());
        onView(withId(R.id.register_view)).check(matches(isDisplayed()));
    }
}
