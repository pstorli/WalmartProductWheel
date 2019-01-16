package com.walmart.productwheel.product.json

class Product
{
    var productId           : String = ""       // Unique Id of the product
    var productName         : String = ""       // Product Name
    var shortDescription    : String = ""       // Short Description of the product
    var longDescription     : String = ""       // Long Description of the product
    var price               : String = ""       // Product price
    var productImage        : String = ""       // Image url for the product
    var reviewRating        : Int  = 0          // Average review rating for the product
    var reviewCount         : Int = 0           //Number of reviews
    var inStock             : Boolean = false   // Returns true if item in stock
}