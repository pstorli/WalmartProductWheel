package com.walmart.productwheel.product.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.walmart.productwheel.product.Product
import com.walmart.productwheel.product.details.ProductDetailFragment
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductListViewHolder(productListFragment:ProductListFragment, itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    lateinit var productListFragment:ProductListFragment
    init {
        this.productListFragment = productListFragment
        itemView.setOnClickListener(this)
    }

    /**
     * bindView
     */
    fun bindView (product: Product) {
        itemView.productName.text = product.name
    }

    /**
     * getProduct
     */
    fun getProduct (pos:Int) : Product
    {
        return productListFragment.getProduct (pos)
    }

    /**
     * onClick
     */
    override fun onClick (view: View?) {
        var productDetailFragment = ProductDetailFragment()
        productDetailFragment.product(getProduct (adapterPosition))
        productListFragment.activityMain?.showFragment(productDetailFragment);
    }
}