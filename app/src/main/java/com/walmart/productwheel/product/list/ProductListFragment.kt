package com.walmart.productwheel.product.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R

class ProductListFragment : androidx.fragment.app.Fragment() {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    lateinit var    recyclerView                            : androidx.recyclerview.widget.RecyclerView
    lateinit var    layoutManager                           : androidx.recyclerview.widget.GridLayoutManager
    lateinit var    productListAdapter                      : ProductListAdapter
    val             recyclerViewOnScrollListener = object   : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
        /**
         * onScrollStateChanged
         */
        override fun onScrollStateChanged (recyclerView: androidx.recyclerview.widget.RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        /**
         * onScrolled
         */
        override fun onScrolled (recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount            = layoutManager.childCount
            val totalItemCount              = layoutManager.itemCount
            val firstVisibleItemPosition    = layoutManager.findFirstVisibleItemPosition()
            var isLastPage                  = visibleItemCount + firstVisibleItemPosition >= MainActivity.instance.comm.totalProducts

            if (!MainActivity.instance.comm.isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= MainActivity.instance.comm.PAGE_SIZE) {
                    // Go to next page.
                    MainActivity.instance.page++

                    // Load products for next page.
                    MainActivity.instance.comm.loadProducts (productListAdapter, MainActivity.instance.page)
                }
            }
        }
    }

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
        recyclerView = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.productListRecycler)

        // create layout
        layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            MainActivity.instance,
            2
        )

        recyclerView.layoutManager = layoutManager

        // Get the padding between items.
        var padding = resources.getDimension(R.dimen.product_padding).toInt();

        // Add a decorator to enforce the padding.
        recyclerView.addItemDecoration(ProductDecoration(padding))

        // Access the RecyclerView Adapter and load the data into it
        productListAdapter = ProductListAdapter (this)

        recyclerView.adapter = productListAdapter

        // Add the recyclerViewOnScrollListener
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);

        // Load first page.
        MainActivity.instance.comm.loadProducts (productListAdapter, MainActivity.instance.page)
    }
}