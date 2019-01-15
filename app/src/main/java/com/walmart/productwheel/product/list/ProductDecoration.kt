package com.walmart.productwheel.product.list

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class ProductDecoration (padding: Int) : RecyclerView.ItemDecoration() {

    var padding       = 3

    init {
        this.padding  = padding
    }
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            top     = padding
            left    = padding
            right   = padding
            bottom  = padding
        }
    }
}