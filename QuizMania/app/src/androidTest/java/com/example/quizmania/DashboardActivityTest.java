package com.example.quizmania;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

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
public class DashboardActivityTest {

    @Rule
    public ActivityScenarioRule<DashboardActivity> rule = new ActivityScenarioRule<>(DashboardActivity.class);

    @Test
    public void Dashboard_Activity_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.dashboard_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Profile_Button_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.profile_button)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_button)).check(matches(isClickable()));
        onView(withId(R.id.profile_button)).check(matches(withText(R.string.profile_button_text)));
    }

    @Test
    public void Quiz_Button_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.quiz_button)).check(matches(isDisplayed()));
        onView(withId(R.id.quiz_button)).check(matches(isClickable()));
        onView(withId(R.id.quiz_button)).check(matches(withText(R.string.quiz_button_text)));
    }

    @Test
    public void Ranking_Button_Should_Be_Displayed_In_View_Test() {
        onView(withId(R.id.ranking_button)).check(matches(isDisplayed()));
        onView(withId(R.id.ranking_button)).check(matches(isClickable()));
        onView(withId(R.id.ranking_button)).check(matches(withText(R.string.ranking_button_text)));
    }

//    @Test
//    public void Click_On_Profile_Button_Should_Display_Profile_Activity_In_View_Test() {
//        ViewInteraction profileButton = onView(withId(R.id.profile_button));
//        profileButton.check(matches(isDisplayed()));
//        profileButton.check(matches(isClickable()));
//        profileButton.perform(click());
//        onView(withId(R.id.profile_view)).check(matches(isDisplayed()));
//    }

    @Test
    public void Click_On_Quiz_Button_Should_Display_Quiz_Activity_In_View_Test() {
        ViewInteraction quizButton = onView(withId(R.id.quiz_button));
        quizButton.check(matches(isDisplayed()));
        quizButton.check(matches(isClickable()));
        quizButton.perform(click());
        onView(withId(R.id.quiz_list_view)).check(matches(isDisplayed()));
    }

    @Test
    public void Click_On_Ranking_Button_Should_Display_Ranking_Activity_In_View_Test() {
        ViewInteraction rankingButton = onView(withId(R.id.ranking_button));
        rankingButton.check(matches(isDisplayed()));
        rankingButton.check(matches(isClickable()));
        rankingButton.perform(click());
        onView(withId(R.id.ranking_view)).check(matches(isDisplayed()));
    }
}
