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
import com.walmart.productwheel.product.json.Comm
import android.util.Log


class ProductListFragment : Fragment() {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var             comm                                    : Comm = Comm()
    lateinit var    recyclerView                            : RecyclerView
    lateinit var    layoutManager                           : GridLayoutManager
    lateinit var    productListAdapter                      : ProductListAdapter
    val             recyclerViewOnScrollListener = object   : RecyclerView.OnScrollListener() {
        /**
         * onScrollStateChanged
         */
        override fun onScrollStateChanged (recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        /**
         * onScrolled
         */
        override fun onScrolled (recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount            = layoutManager.childCount
            val totalItemCount              = layoutManager.itemCount
            val firstVisibleItemPosition    = layoutManager.findFirstVisibleItemPosition()
            var isLastPage                  = visibleItemCount + firstVisibleItemPosition >= comm.totalProducts

            if (!comm.isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= comm.PAGE_SIZE) {
                    // Go to next page.
                    MainActivity.instance.page++

                    // Load products for next page.
                    comm.loadProducts (productListAdapter, MainActivity.instance.page)
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
        recyclerView = view.findViewById<RecyclerView>(R.id.productListRecycler)

        layoutManager = GridLayoutManager(MainActivity.instance, 2)

        recyclerView.layoutManager = layoutManager

        // Access the RecyclerView Adapter and load the data into it
        productListAdapter = ProductListAdapter (this)

        recyclerView.adapter = productListAdapter

        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);

        // Load first page.
        comm.loadProducts (productListAdapter, MainActivity.instance.page)


    }
}