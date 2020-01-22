package com.example.quizmania;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.mockwebserver.MockWebServer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> rule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void Login_Activity_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.login_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Title_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.login_text)).check(matches(isDisplayed()));
        onView(withId(R.id.login_text)).check(matches(withText(R.string.login_text_value)));
    }

    @Test
    public void Login_Form_Should_Be_Displayed_In_View_Test() {

        onView(withId(R.id.email_edit_text)).check(matches(isDisplayed()));
        onView(withId(R.id.password_edit_text)).check(matches(isDisplayed()));
        onView(withId(R.id.button_login_id)).check(matches(isDisplayed()));
        onView(withId(R.id.button_login_id)).check(matches(withText(R.string.login_button_text)));
    }

    @Test
    public void Login_With_Empty_Form_Should_Be_Forbidden_In_View_Test() {
        onView(withId(R.id.button_login_id)).check(matches(isDisplayed()));
        onView(withId(R.id.button_login_id)).check(matches(withText(R.string.login_button_text)));
        onView(withId(R.id.button_login_id)).check(matches(isClickable()));
        ViewInteraction loginButton = onView(withId(R.id.button_login_id));
        loginButton.check(matches(isClickable()));
        loginButton.perform(click());
        onView(withId(R.id.login_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Login_With_Invalid_Email_Should_Be_Forbidden_In_View_Test() {
        ViewInteraction emailEdit = onView(withId(R.id.email_edit_text));
        emailEdit.perform(typeText("invalidEmail"));
        emailEdit.check(matches(withText("invalidEmail")));
        emailEdit.check(matches(hasErrorText("To chyba nie email :(")));
    }
}
