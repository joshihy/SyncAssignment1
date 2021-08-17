package com.example.syncassignment.ui.profile

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.syncassignment.R
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ProfileFragmentTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun test_check_all_views_visibility() {
        var bundle = Bundle()
        val scenario = launchFragmentInContainer<ProfileFragment>(bundle)
        onView(withId(R.id.image_view_profile)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_name)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_phone)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_linkedin)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_phone)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_email)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_experience)).check(matches(isDisplayed()))
    }
}