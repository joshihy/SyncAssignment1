package com.example.syncassignment.ui.deals

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.syncassignment.R
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class DealsFragmentTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun testList() {
        val scenario = launchFragmentInContainer<DealsFragment>()
        //onView(withId(R.id.recycler_view_deal_item_list)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        /*onView(withId(R.id.recycler_view_deal_item_list))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<DealItemAdapter.DealItemViewHolder>(1,
                    typeTextInChildViewWithId(R.id.my_edit_text, "your text")))*/
    }
}