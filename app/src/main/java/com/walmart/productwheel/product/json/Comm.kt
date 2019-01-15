package com.walmart.productwheel.product.json

import android.util.Log
import android.widget.ImageView
import com.walmart.productwheel.MainActivity
import okhttp3.*
import java.net.URL
import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.picasso.Picasso
import com.walmart.productwheel.product.list.ProductListAdapter

class Comm {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Consts
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val TAG                     ="Walmart Product Wheel"

    val WALMART_LABS_URL        = "https://mobile-tha-server.firebaseapp.com"

    val WALMART_PRODUCTS_URL    = "/walmartproducts"

    val PAGE_SIZE               = 30 // Max items per request is 30

    var totalProducts           = 0 // How many products are there?

    var isLoading               = false  // Are we loading?

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var client = OkHttpClient()

    /**
     * " https://mobile-tha-server.firebaseapp.com/walmartproducts/1/1 "
     */
    fun loadProducts (productListAdapter : ProductListAdapter, pageNumber:Int)
    {
        isLoading = true

        Thread {
            try {
                val url = WALMART_LABS_URL + WALMART_PRODUCTS_URL + "/" + pageNumber.toString() + "/" + PAGE_SIZE.toString();

                val products = URL(url).readText()

                val productInfo = ObjectMapper().readValue(products, ProductInfo::class.java)

                Log.i (TAG, products)

                MainActivity.instance.runOnUiThread({
                    MainActivity.instance.addProducts (productInfo)
                    productListAdapter.notifyDataSetChanged()
                    isLoading = false
                })

                totalProducts = Integer.parseInt(productInfo.totalProducts)
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }

    /**
     * Load the image for this product.
     */
    fun loadImage (product:Product, productImage: ImageView) {
        val url = WALMART_LABS_URL + product.productImage

        // Load remote image.
        Picasso.get()
            .load(url)
            .into(productImage)
    }
}