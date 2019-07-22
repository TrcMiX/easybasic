package com.pingerx.basiclib.base.mvp

import android.os.Bundle
import com.pingerx.basiclib.base.basic.IMvpContract
import com.pingerx.basiclib.base.fragment.BaseNavFragment

/**
 * @author Pinger
 * @since 2018/12/25 15:25
 *
 * 添加MVP的Fragment，并且添加依赖注入
 */

abstract class BaseMvpNavFragment<P : IMvpContract.Presenter<*>> : BaseNavFragment(), IMvpContract.View {

    protected lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = attachPresenter()
        attachView()
        super.onCreate(savedInstanceState)
    }

    abstract fun attachView()

    abstract fun attachPresenter(): P

    override fun isActive(): Boolean = isAdded

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}