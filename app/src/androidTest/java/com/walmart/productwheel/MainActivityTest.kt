package com.walmart.productwheel

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.walmart.productwheel.product.list.ProductListViewHolder
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    /**
     * Ths test will scroll down to Knightsbridge and click it.
     */
    @Test
    fun selectTest () {
        IdlingRegistry.getInstance().register(MainActivity.instance.idlingRes)
        onView(withId(R.id.productListRecycler))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ProductListViewHolder>(0, click()));
        IdlingRegistry.getInstance().unregister(MainActivity.instance.idlingRes)

    }
}