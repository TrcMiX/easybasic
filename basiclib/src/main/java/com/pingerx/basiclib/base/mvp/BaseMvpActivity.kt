package com.pingerx.basiclib.base.mvp

import android.os.Bundle
import com.pingerx.basiclib.base.activity.BaseNavActivity
import com.pingerx.basiclib.base.basic.IMvpContract

/**
 * @author Pinger
 * @since 2019/1/3 23:06
 */
abstract class BaseMvpActivity<P : IMvpContract.Presenter<*>> : BaseNavActivity(), IMvpContract.View {

    protected open lateinit var mPresenter: P

    override fun isActive(): Boolean = !isDestroyed

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = attachPresenter()
        attachView()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    abstract fun attachView()

    abstract fun attachPresenter(): P
}