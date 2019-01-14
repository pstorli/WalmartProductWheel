package com.walmart.productwheel.product.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import com.walmart.productwheel.product.Product

class ProductListAdapter(productListFragment:ProductListFragment, products: ArrayList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Vars
     */
    lateinit var productListFragment: ProductListFragment
    var products: List<Product>

    init {
        this.productListFragment = productListFragment
        this.products = products
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductListViewHolder(productListFragment, view)
    }

    /**
     * getItemCount
     */
    override fun getItemCount(): Int = products.size

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as ProductListViewHolder
        movieViewHolder.bindView(products[position])
    }

    /**
     * setProductList
     */
    fun setProductList(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}