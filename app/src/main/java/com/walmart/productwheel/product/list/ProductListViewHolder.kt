package com.walmart.productwheel.product.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.product.Product
import com.walmart.productwheel.product.details.ProductDetailFragment
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductListViewHolder(productListAdapter:ProductListAdapter, itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var productListAdapter:ProductListAdapter
    init {
        this.productListAdapter = productListAdapter
        itemView.setOnClickListener(this)
    }

    /**
     * bindView
     */
    fun bindView (product: Product) {
        itemView.productName.text = product.name
    }

    /**
     * onClick
     */
    override fun onClick (view: View?) {
        // Move product position to where we just clicked.
        MainActivity.instance.position = adapterPosition

        productListAdapter.notifyDataSetChanged();

        // Now show that products details.
        MainActivity.instance.showFragment(ProductDetailFragment());
    }
}