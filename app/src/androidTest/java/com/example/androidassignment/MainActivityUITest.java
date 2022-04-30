package com.example.androidassignment;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {

        ViewInteraction inputText = onView(withId(R.id.input1));
        ViewInteraction inputIndex = onView(withId(R.id.input2));
        ViewInteraction button = onView(withId(R.id.button));
        ViewInteraction output = onView(withId(R.id.out));



////       First test
        String validText = "test";
        String validIndex = "3";
        Suffixer validSuffix = new Suffixer(validText,validIndex);

        inputText.perform(click());
        inputText.perform(replaceText(validText), closeSoftKeyboard());
        inputIndex.perform(click());
        inputIndex.perform(replaceText(validIndex.toString()), closeSoftKeyboard());
        button.perform(click());

        try{
            String validResult = validSuffix.getSuffix();
            output.check(matches(withText("Suffix is: "+ validResult)));
        } catch (Exception e) {
            output.check(matches(withText(e.getMessage())));
        }

//        Second test
        String invalidIndex = "invalidIndex";
        Suffixer invalidSuffix = new Suffixer(validText,invalidIndex);

        inputIndex.perform(click());
        inputIndex.perform(replaceText(invalidIndex), closeSoftKeyboard());
        button.perform(click());
        try{
            String invalidResult = invalidSuffix.getSuffix();
        } catch (Exception e) {
            output.check(matches(withText(R.string.invalid_number)));
        }
//
////        Third test
        String greaterIndex = "7";
        invalidSuffix = new Suffixer(validText,greaterIndex);

        inputIndex.perform(click());
        inputIndex.perform(replaceText(greaterIndex), closeSoftKeyboard());
        button.perform(click());

        try{
            String invalidResult = invalidSuffix.getSuffix();

        } catch (Exception e) {
            output.check(matches(withText("Index should be greater than 0 and smaller than 3")));
        }

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
