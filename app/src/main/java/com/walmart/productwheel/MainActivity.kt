package com.walmart.productwheel

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import com.walmart.productwheel.product.json.Comm
import com.walmart.productwheel.product.json.Product
import com.walmart.productwheel.product.json.ProductInfo
import com.walmart.productwheel.product.list.ProductListFragment

class MainActivity() : AppCompatActivity() {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var products     : ArrayList<Product> = ArrayList()
    var position     : Int  =  0
    var page         : Int  =  1
    var comm         : Comm = Comm()

    /**
     * constructor
     */
    init {
        inst = this;
    }

    //
    /**
     * Instance of MainActivity
     */
    companion object {
        private lateinit var inst: MainActivity

        val instance: MainActivity
            get() {
                return inst
            }
    }

    /**
     * How many products do we have?
     */
    fun getProductCount () : Int {
        return products.size
    }

    /**
     * getProduct from products list at a position or at current position
     */
    fun getProduct () : Product = getProduct (position)
    fun getProduct (pos: Int) : Product {
        var product = Product()
        if (products.size>0 && pos<products.size) {
            product = products[pos]
        }
        return product;
    }

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add Walmart splash icon to toolbar.
        var actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.walmart_spark);
        }

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

    /**
     * addProduct
     */
    fun addProduct(product: Product) {
        products.add(product)
    }

    /**
     * addProducts
     */
    fun addProducts(productInfo : ProductInfo) {
        for (product in productInfo.products!!) {
            addProduct(product)
        }
    }

    /**
     * Show a custom snackbar.
     */
    fun showSnackbar (vew: View, toastText : String, textColor:Int)
    {
        var snackBar = Snackbar.make(
            vew,                    // Parent view
            toastText,              // Message to show
            Snackbar.LENGTH_SHORT   // How long to display the message.
        )

        // Set the text color to walmart blue
        snackBar.view.setBackgroundColor(MainActivity.instance.getResources().getColor(R.color.walmart))

        // Set the text color to white
        val mainTextView   = snackBar.getView().findViewById(android.support.design.R.id.snackbar_text) as TextView
        val actionTextView = snackBar.getView().findViewById(android.support.design.R.id.snackbar_action) as TextView

        // To Change Text Color for Message and Action
        mainTextView.setTextColor  (MainActivity.instance.getResources().getColor(textColor))
        actionTextView.setTextColor(MainActivity.instance.getResources().getColor(textColor))

        // Set the text size
        mainTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_medium));
        actionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_medium));

        // Now, finally, show the snack bar.
        snackBar.show()
    }
}
