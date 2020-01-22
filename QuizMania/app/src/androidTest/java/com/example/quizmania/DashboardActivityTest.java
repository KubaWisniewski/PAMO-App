package com.example.quizmania;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;


import com.example.quizmania.service.Api;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class DashboardActivityTest {
    private MockWebServer server;
    @Rule
    public ActivityScenarioRule<DashboardActivity> rule = new ActivityScenarioRule<>(DashboardActivity.class);

    @Before
    public void setUp() throws IOException {
        if (server == null) {
            server = new MockWebServer();
            server.setDispatcher(new Dispatcher() {
                @Override
                public MockResponse dispatch(RecordedRequest request) {
                    switch (request.getPath()) {
                        case "/api/auth/signin":
                        case "/api/quiz":
                        case "/api/quiz/ranking":
                            return new MockResponse()
                                    .setResponseCode(200)
                                    .setBody("");
                        case "/api/user/me":
                            return new MockResponse()
                                    .setResponseCode(200)
                                    .setBody("{\n" +
                                            "  \"id\": 65,\n" +
                                            "  \"username\": \"test\",\n" +
                                            "  \"password\": \"$2a$10$VvbL6rai1llPB0egYuE0D.cA4m6J9BTHGU.BMF8sjMvrg/lM99JrW\",\n" +
                                            "  \"gender\": \"MALE\",\n" +
                                            "  \"email\": \"test@test.com\",\n" +
                                            "  \"rolesDto\": [\n" +
                                            "    {\n" +
                                            "      \"id\": 1,\n" +
                                            "      \"roleName\": \"ROLE_USER\"\n" +
                                            "    }\n" +
                                            "  \"balance\": 10,\n" +
                                            "  \"dateOfBirth\": \"2020-01-17\",\n" +
                                            "  \"userQuizDtos\": null\n" +
                                            "}");
                    }
                    throw new AssertionError("Unexpected request: " + request);
                }
            });
            server.start();
            Api.BASE_URL = server.url("/").toString();
        }
    }

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

    @Test
    public void Click_On_Profile_Button_Should_Display_Profile_Activity_In_View_Test() {
        ViewInteraction profileButton = onView(withId(R.id.profile_button));
        profileButton.check(matches(isDisplayed()));
        profileButton.check(matches(isClickable()));
        profileButton.perform(click());
        onView(withId(R.id.profile_view)).check(matches(isDisplayed()));
    }

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
