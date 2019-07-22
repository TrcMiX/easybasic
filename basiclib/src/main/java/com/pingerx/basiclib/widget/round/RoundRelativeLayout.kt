package com.pingerx.basiclib.widget.round

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

/**
 * 用于需要圆角矩形框背景的RelativeLayout的情况,减少直接使用RelativeLayout时引入的shape资源文件
 * 参考：https://github.com/H07000223/FlycoRoundView
 */
class RoundRelativeLayout : RelativeLayout {

    private val delegate: RoundViewDelegate

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        delegate = RoundViewDelegate(this, context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (delegate.isWidthHeightEqual() && width > 0 && height > 0) {
            val max = Math.max(width, height)
            val measureSpec = View.MeasureSpec.makeMeasureSpec(max, View.MeasureSpec.EXACTLY)
            super.onMeasure(measureSpec, measureSpec)
            return
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (delegate.isRadiusHalfHeight()) {
            delegate.setCornerRadius(height / 2)
        } else {
            delegate.setBgSelector()
        }
    }
}
