package me.weeravit.androidnewssample.module.news;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.weeravit.androidnewssample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsActivityTest {

    /*
        This test is support mock variant only
      */

    @Rule
    public ActivityTestRule<NewsActivity> mActivityTestRule = new ActivityTestRule<>(NewsActivity.class);

    @Test
    public void newsActivityTest() {
        int firstPosition = 0;
        int lastPosition = 9;
        String firstNewsTitle = "Android Development Best Practices";
        String lastNewsTitle = "Clean Android Code";

        onView(withId(R.id.recycler_view))
                .perform(scrollToPosition(firstPosition));

        ViewInteraction textView = onView(
                allOf(withId(R.id.text_title), withText(firstNewsTitle),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.card_view),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText(firstNewsTitle)));

        onView(withId(R.id.recycler_view))
                .perform(scrollToPosition(lastPosition));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.text_title), withText(lastNewsTitle),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.card_view),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText(lastNewsTitle)));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
