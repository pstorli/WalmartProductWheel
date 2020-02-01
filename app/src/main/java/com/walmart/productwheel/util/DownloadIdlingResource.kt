package com.walmart.productwheel.util

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean

class DownloadIdlingResource (private val resourceName: String) : IdlingResource {
    private val isIdle = AtomicBoolean(true)

    // written from main thread, read from any thread.
    @Volatile private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String = resourceName

    override fun isIdleNow(): Boolean = isIdle.get()

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    fun setIdle(isIdleNow: Boolean) {
        if (isIdleNow == isIdle.get()) return
        isIdle.set(isIdleNow)
        if (isIdleNow) {
            resourceCallback?.onTransitionToIdle()
        }
    }
}
