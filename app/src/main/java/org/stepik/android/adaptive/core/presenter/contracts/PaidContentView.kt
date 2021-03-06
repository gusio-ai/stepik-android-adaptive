package org.stepik.android.adaptive.core.presenter.contracts

import org.solovyev.android.checkout.ActivityCheckout
import org.solovyev.android.checkout.Billing

interface PaidContentView {
    fun createCheckout(): ActivityCheckout

    fun showContentProgress()
    fun hideContentProgress()
    fun onPurchasesNotSupported()

    fun showProgress()
    fun hideProgress()
    fun onPurchaseError()
}