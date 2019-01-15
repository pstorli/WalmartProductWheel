package com.walmart.productwheel.product.io

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log
import com.walmart.productwheel.MainActivity
import okhttp3.*
import java.net.URL
import com.fasterxml.jackson.databind.ObjectMapper
import com.walmart.productwheel.product.list.ProductListAdapter

class Comm {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Consts
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val WALMART_LABS_URL = "https://mobile-tha-server.firebaseapp.com"

    val WALMART_PRODUCTS_URL = "/walmartproducts"

    val TAG ="WPM"

    val PAGE_SIZE = 30 // Max items per request is 30

    // imageView.loadUrl("http://....")

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var client = OkHttpClient()

    /**
     * " https://mobile-tha-server.firebaseapp.com/walmartproducts/1/1 "
     */
    fun loadProducts (productListAdapter : ProductListAdapter, pageNumber:Int)
    {
        Thread {
            try {
                val url = WALMART_LABS_URL + WALMART_PRODUCTS_URL + "/" + pageNumber.toString() + "/" + PAGE_SIZE.toString();

                val products = URL(url).readText()

                val productInfo = ObjectMapper().readValue(products, ProductInfo::class.java)

                Log.i (TAG, products)

                MainActivity.instance.runOnUiThread({
                    MainActivity.instance.addProducts (productInfo)
                    productListAdapter.notifyDataSetChanged()
                })
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }
}