package com.walmart.productwheel.product.io

class ProductInfo  () {
    var statusCode: String? = null

    var pageSize: String? = null

    var pageNumber: String? = null

    var totalProducts: String? = null

    var products: Array<Product>? = null

    override fun toString(): String {
        return "ClassPojo [statusCode = $statusCode, pageSize = $pageSize, pageNumber = $pageNumber, totalProducts = $totalProducts, products = $products]"
    }
}