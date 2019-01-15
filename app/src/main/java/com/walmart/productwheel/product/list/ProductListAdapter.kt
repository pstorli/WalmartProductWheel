package com.walmart.productwheel.product.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import kotlinx.android.synthetic.main.product_list_item.view.*

@Suppress("DEPRECATION")
class ProductListAdapter(productListFragment:ProductListFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Vars
     */
    var productListFragment: ProductListFragment

    init {
        this.productListFragment = productListFragment
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductListViewHolder(this, view)
    }

    /**
     * getItemCount
     */
    override fun getItemCount() : Int {
        return MainActivity.instance.getProductCount ()
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val productListViewHolder = viewHolder as ProductListViewHolder
        productListViewHolder.bindView (MainActivity.instance.getProduct (position))

        // Change text color of the selected one to black, others blue.
        val textColor: Int = if (position == MainActivity.instance.position) R.color.orange else R.color.walmart

        // Set the text color to orange.
        productListViewHolder.itemView.productName.setTextColor (MainActivity.instance.getResources().getColor(textColor));
    }
}