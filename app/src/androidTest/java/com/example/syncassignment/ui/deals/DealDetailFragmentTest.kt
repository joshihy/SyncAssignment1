package com.example.syncassignment.ui.deals

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.syncassignment.R
import com.example.syncassignment.data.DealItem
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DealDetailFragmentTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun test_check_all_views_visibility() {
        var bundle = Bundle()
        bundle.putParcelable("deal_data", DealItem("12", "item1", "description", "h",12.00,15.00, "provider","https://picsum.photos/200","https://picsum.photos/200",5,5,10.0 ))
        val scenario = launchFragmentInContainer<DealDetailFragment>(bundle)
        onView(withId(R.id.text_view_item_name)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_item_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_cost)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_cost_original)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_comments)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_likes)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_provider)).check(matches(isDisplayed()))
        onView(withId(R.id.button_see_deal)).check(matches(isDisplayed()))
    }
}