package com.walmart.productwheel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment (ProductListFragment())
    }

    /**
     * Show a fragment.
     */
    fun showFragment (fragment: Fragment)
    {
        // Get the fragment support manager instance
        val manager = supportFragmentManager

        // Begin the fragment transition using support fragment manager
        val transaction = manager.beginTransaction()

        // Replace the fragment on container
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)

        // Finishing the transition
        transaction.commit()
    }

}
