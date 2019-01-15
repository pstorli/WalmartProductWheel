package com.walmart.productwheel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.walmart.productwheel.product.Product
import com.walmart.productwheel.product.list.ProductListFragment

class MainActivity() : AppCompatActivity() {

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var products     : ArrayList<Product> = ArrayList()
    var position     : Int =  0

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
        var product = Product ("Nothing")
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

        addProducts()

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


}
