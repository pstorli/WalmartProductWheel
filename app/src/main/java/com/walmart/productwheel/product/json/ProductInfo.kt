package com.walmart.productwheel.product.json

class ProductInfo  () {
    var statusCode      = ""

    var pageSize        = ""

    var pageNumber      = ""

    var totalProducts   = ""

    var products: Array<Product>? = null

    override fun toString(): String {
        return "ClassPojo [statusCode = $statusCode, pageSize = $pageSize, pageNumber = $pageNumber, totalProducts = $totalProducts, products = $products]"
    }
}