package com.walmart.productwheel.product.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import com.walmart.productwheel.RootFragment
import com.walmart.productwheel.product.list.ProductListFragment
import kotlinx.android.synthetic.main.product_list_item.view.*

internal class ProductDetailPage (): RootFragment() {

    // Vars.
    lateinit var productName        : TextView
    lateinit var productImage       : ImageView
    lateinit var inStockBtn         : Button
    lateinit var showProdListBtn    : Button
             var page               = MainActivity.instance.position

    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.product_detail_page, container, false)

        productName     = view.findViewById(R.id.productName)
        productImage    = view.findViewById(R.id.productImage)
        inStockBtn      = view.findViewById<Button>(R.id.prodInStock)
        showProdListBtn = view.findViewById<Button>(R.id.showProdListBtn)
        showProdListBtn.setOnClickListener(
            {
                MainActivity.instance.showFragment(ProductListFragment())
            }
        )
        bind ()

        return view;
    }

    /**
     * bind
     */
    fun bind ()
    {
        var product = MainActivity.instance.getProduct (page)
        productName.text = product.productName
        MainActivity.instance.comm.loadImage (product, productImage)

        // Set text to in or out of stock and x or check icon.
        if (product.inStock) {
            // In stock
            inStockBtn.text = MainActivity.instance.getString(R.string.in_stock)
            inStockBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.check, 0, 0, 0);
        } else {
            // Out of stock
            inStockBtn.text = MainActivity.instance.getString(R.string.out_of_stock)
            inStockBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red_x, 0, 0, 0);
        }
    }
}