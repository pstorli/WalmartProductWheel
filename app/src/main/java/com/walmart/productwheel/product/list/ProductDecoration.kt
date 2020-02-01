package com.walmart.productwheel.product.list

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class ProductDecoration (padding: Int) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    var padding       = 3

    init {
        this.padding  = padding
    }
    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        with(outRect) {
            top     = padding
            left    = padding
            right   = padding
            bottom  = padding
        }
    }
}