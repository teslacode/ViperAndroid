package com.adefruandta.viper.routers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.adefruandta.viper.contracts.ViperContract.Router

/**
 * Created by adefruandta on 8/7/17.
 */

open class ViperRouter : Router {

    // region Attributes

    protected var activity: Activity? = null

    protected var fragment: Fragment? = null

    protected var context: Context? = null

    protected lateinit open var intent: Intent

    // endregion

    // region Constructor

    constructor(activity: Activity) {
        this.activity = activity
        this.fragment = null
        this.context = activity
    }

    constructor(fragment: Fragment) {
        this.activity = null
        this.fragment = fragment
        this.context = fragment.context
    }

    constructor(context: Context) {
        this.activity = null
        this.fragment = null
        this.context = context
    }

    constructor(router: ViperRouter) {
        this.activity = router.activity
        this.fragment = router.fragment
        this.context = router.context
    }

    // endregion

    // region Base Router

    open fun open() {
        startActivity(intent)
    }

    protected open fun startActivity(intent: Intent) {
        if (this.activity != null) {
            this.activity?.startActivity(intent)
            return
        }

        if (this.fragment != null) {
            this.fragment?.startActivity(intent)
            return
        }

        if (this.context != null) {
            this.context?.startActivity(intent)
            return
        }
    }

    protected open fun startActivity(intent: Intent, options: Bundle?) {
        if (this.activity != null) {
            this.activity?.startActivity(intent, options)
            return
        }

        if (this.fragment != null) {
            this.fragment?.startActivity(intent, options)
            return
        }

        if (this.context != null) {
            this.context?.startActivity(intent, options)
            return
        }
    }

    protected open fun startActivityForResult(intent: Intent, requestCode: Int) {
        if (this.activity != null) {
            this.activity?.startActivityForResult(intent, requestCode)
            return
        }

        if (this.fragment != null) {
            this.fragment?.startActivityForResult(intent, requestCode)
            return
        }
    }

    protected open fun finish() {
        if (activity != null) {
            activity?.finish()
            return
        }

        if (fragment != null) {
            fragment?.activity?.finish()
            return
        }
    }

    // endregion

    // region Router

    override fun unregister() {
        this.activity = null
        this.fragment = null
        this.context = null
    }

    // endregion
}
