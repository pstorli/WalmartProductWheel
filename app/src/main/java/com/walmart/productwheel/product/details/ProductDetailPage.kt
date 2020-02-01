package com.walmart.productwheel.product.details

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.walmart.productwheel.MainActivity
import com.walmart.productwheel.R
import com.walmart.productwheel.RootFragment
import com.walmart.productwheel.product.list.ProductListFragment

internal class ProductDetailPage (): RootFragment() {

    // Vars.
    lateinit var productName            : TextView
    lateinit var productImage           : ImageView
    lateinit var inStockBtn             : Button
    lateinit var productId              : EditText
    lateinit var productPrice           : EditText
    lateinit var productCount           : EditText
    lateinit var productRating          : EditText
    lateinit var productDescShortLbl    : TextView
    lateinit var productDescShort       : EditText
    lateinit var productDescLongLbl     : TextView
    lateinit var productDescLong        : TextView
    lateinit var showProdListBtn        : Button
    lateinit var vew                    : View
             var page                   = MainActivity.instance.position

    /**
     * onCreateView
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vew = inflater.inflate(R.layout.product_detail_page, container, false)

        productName                     = vew.findViewById(R.id.productName)           as TextView
        productImage                    = vew.findViewById(R.id.productImage)          as ImageView
        inStockBtn                      = vew.findViewById(R.id.prodInStock)           as Button
        productId                       = vew.findViewById(R.id.productId)             as EditText
        productPrice                    = vew.findViewById(R.id.productPrice)          as EditText
        productCount                    = vew.findViewById(R.id.productCount)          as EditText
        productRating                   = vew.findViewById(R.id.productRating)         as EditText
        productDescShortLbl             = vew.findViewById(R.id.productDescShortLbl)   as TextView
        productDescShort                = vew.findViewById(R.id.productDescShort)      as EditText
        productDescLongLbl              = vew.findViewById(R.id.productDescLongLbl)    as TextView
        productDescLong                 = vew.findViewById(R.id.productDescLong)       as TextView
        showProdListBtn                 = vew.findViewById(R.id.showProdListBtn)       as Button

        showProdListBtn.setOnClickListener(
            {
                MainActivity.instance.showFragment(ProductListFragment())
            }
        )
        bind ()

        return vew;
    }

    /**
     * bind
     */
    fun bind ()
    {
        // Get the read only product.
        val product = MainActivity.instance.getProduct (page)

        // Set product name
        productName.text = product.productName

        // Set the product image.
        MainActivity.instance.comm.loadImage (product, productImage)

        // Set text to in or out of stock and x or check icon.
        var toastText: String
        var textColor: Int
        if (product.inStock) {
            // In stock
            textColor = R.color.green_lt
            toastText = MainActivity.instance.getString(R.string.in_stock_toast)
            inStockBtn.text = MainActivity.instance.getString(R.string.in_stock)
            inStockBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.check, 0, 0, 0);
        }
        else {
            // Out of stock
            textColor = R.color.red
            toastText = MainActivity.instance.getString(R.string.out_of_stock_toast)
            inStockBtn.text = MainActivity.instance.getString(R.string.out_of_stock)
            inStockBtn.setCompoundDrawablesWithIntrinsicBounds( R.drawable.red_x, 0, 0, 0);
        }

        // Add click listener to stock button to show snackbar toast message.
        inStockBtn.setOnClickListener {
            MainActivity.instance.showSnackbar(vew, toastText, textColor)
        }

        // Set product id
        productId.setText (product.productId)

        // Set product price
        productPrice.setText (product.price)

        // Set product count
        productCount.setText (Integer.toString(product.reviewCount))

        // Set product rating
        productRating.setText (Integer.toString(product.reviewRating))

        // Set product description short
        var shortText = htmlToSpan (product.shortDescription);

        if (shortText.isBlank()) {
            productDescShortLbl.visibility = View.GONE
            productDescShort.visibility = View.GONE
        }
        else {
            productDescShort.setText (shortText)
        }

        // Set product description long
        var longText = htmlToSpan (product.longDescription);

        if (longText.isBlank()) {
            productDescLongLbl.visibility = View.GONE
            productDescLong.visibility = View.GONE
        }
        else {
            productDescLong.setText (longText)
        }
    }

    /**
     * Convert html text to normal text
     */
    fun htmlToSpan (text:String) : Spanned
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            // This has been depreciated.
            return Html.fromHtml(text)

        } else {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        }
    }
}