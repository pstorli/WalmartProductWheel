package com.walmart.productwheel.product.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import com.walmart.productwheel.product.io.Comm

class ProductListFragment : Fragment() {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var comm         : Comm = Comm()

    /**
     * onCreateView
     */
    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // Get the custom view for this fragment layout
        val view = inflater.inflate(R.layout.product_list_fragment, container, false)

        // Return the fragment view/layout
        return view
    }

    /**
     * onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch the recycler
        var recyclerView : RecyclerView = view.findViewById<RecyclerView>(R.id.productListRecycler)

        recyclerView.layoutManager = GridLayoutManager(MainActivity.instance, 2) as RecyclerView.LayoutManager?

        // Access the RecyclerView Adapter and load the data into it
        val productListAdapter = ProductListAdapter (this)

        recyclerView.adapter = productListAdapter

        // Load page.
        comm.loadProducts (productListAdapter, MainActivity.instance.page)


    }
}