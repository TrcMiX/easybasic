package com.pingerx.basiclib.base.mvp

import com.pingerx.basiclib.base.basic.IMvpContract

/**
 * @author Pinger
 * @since 2018/12/25 15:25
 *
 * 添加MVP的Fragment，并且添加依赖注入
 */

abstract class BaseMvpFragment<P : IMvpContract.Presenter<*>> : BaseMvpNavFragment<P>(), IMvpContract.View {

    final override fun isShowToolBar() = false

    final override fun isSwipeBackEnable() = false
}