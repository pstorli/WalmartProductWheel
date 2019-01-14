package com.walmart.productwheel.product.list

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walmart.productwheel.R
import com.walmart.productwheel.RootFragment
import com.walmart.productwheel.product.Product

class ProductListFragment : RootFragment() {
    // Vars
    private val products : ArrayList<Product> = ArrayList()

    /**
     * onCreateView
     */
    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        val view = inflater.inflate(R.layout.product_list_fragment, container, false)

        // Start fetching products.
        addProducts ()

        // Return the fragment view/layout
        return view
    }

    /**
     * getProduct
     */
    fun getProduct (pos:Int) : Product
    {
        return products.get(pos)
    }

    /**
     * addProducts
     */
    fun addProducts() {
        products.add(Product("Prod1"))
        products.add(Product("Prod2"))
        products.add(Product("Prod3"))
        products.add(Product("Prod4"))
        products.add(Product("Prod5"))
        products.add(Product("Prod6"))
        products.add(Product("Prod7"))
        products.add(Product("Prod8"))
        products.add(Product("Prod9"))
        products.add(Product("Prod10"))
    }

    /**
     * onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch the recycler
        var recyclerView : RecyclerView = view.findViewById<RecyclerView>(R.id.productListRecycler)

        recyclerView.layoutManager = GridLayoutManager(activityMain, 2)

        // Access the RecyclerView Adapter and load the data into it
        recyclerView.adapter = ProductListAdapter (this, products)

    }
}