package com.walmart.productwheel.product.json

import android.util.Log
import android.widget.ImageView
import com.walmart.productwheel.MainActivity
import okhttp3.*
import java.net.URL
import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.picasso.Picasso
import com.walmart.productwheel.product.list.ProductListAdapter
import com.fasterxml.jackson.core.JsonProcessingException
import java.io.*
import java.util.*
import java.util.Arrays.asList
import java.util.Base64.getEncoder
import java.util.Base64.getDecoder



class Comm {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Consts
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val WALMART_LABS_URL = "https://mobile-tha-server.firebaseapp.com"

    val WALMART_PRODUCTS_URL = "/walmartproducts"

    val PAGE_SIZE = 30 // Max items per request is 30

    var totalProducts = 0 // How many products are there?

    var isLoading = false  // Are we loading?

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var client = OkHttpClient()

    /**
     * " https://mobile-tha-server.firebaseapp.com/walmartproducts/1/1 "
     */
    fun loadProducts(productListAdapter: ProductListAdapter, pageNumber: Int) {
        isLoading = true

        Thread {
            try {
                val url =
                    WALMART_LABS_URL + WALMART_PRODUCTS_URL + "/" + pageNumber.toString() + "/" + PAGE_SIZE.toString();

                val products = URL(url).readText()

                val productInfo = getProductInfo(products)

                Log.i(MainActivity.instance.TAG, products)

                MainActivity.instance.runOnUiThread({
                    MainActivity.instance.addProducts(productInfo)
                    productListAdapter.notifyDataSetChanged()
                    isLoading = false
                })

                totalProducts = Integer.parseInt(productInfo.totalProducts)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

    }

    /**
     * Load the image for this product.
     */
    fun loadImage(product: Product, productImage: ImageView) {
        val url = WALMART_LABS_URL + product.productImage

        // Load remote image.
        Picasso.get()
            .load(url)
            .into(productImage)
    }

    /**
     * jsonToString
     */
    fun jsonToString(products: ArrayList<Product>): String {
        var json = ""

        val objectMapper = ObjectMapper()
        try {
            json = objectMapper.writeValueAsString(products)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }

        return json;

    }

    /**
     * getProductInfo
     */
    fun getProductInfo(jsonProductInfo: String): ProductInfo {
        return ObjectMapper().readValue(jsonProductInfo, ProductInfo::class.java)
    }

    /**
     * getProducts
     */
    fun getProducts(jsonProducts: String): ArrayList<Product> {
        return fromString(jsonProducts) as ArrayList<Product>
    }

    /**
     * productsToString
     */
    fun productsToString(products:ArrayList<Product>) : String{
        return toString (products)
    }


    /** Read the object from Base64 string.  */
    @Throws(IOException::class, ClassNotFoundException::class)
    private fun fromString (str: String): Any {
        val data = android.util.Base64.decode(str, android.util.Base64.DEFAULT);
        val ois = ObjectInputStream(
            ByteArrayInputStream(data)
        )
        val o = ois.readObject()
        ois.close()
        return o
    }

    /** Write the object to a Base64 string.  */
    @Throws(IOException::class)
    private fun toString (o: Serializable): String {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(o)
        oos.close()
        return android.util.Base64.encodeToString(baos.toByteArray(), android.util.Base64.DEFAULT)
    }
}