package com.xgw.roundviewshape.widget.roundview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.xgw.roundviewshape.widget.roundview.delegate.BaseDelegate;
import com.xgw.roundviewshape.widget.roundview.delegate.RoundViewDelegate;

/**
 * Created by XieGuangwei on 2017/11/1.
 * 圆角帧布局
 */

public class RoundViewFrameLayout extends FrameLayout {
    private BaseDelegate delegate;

    public RoundViewFrameLayout(Context context) {
        this(context, null);
    }

    public RoundViewFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundViewFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        delegate = new RoundViewDelegate(context, this, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        delegate.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size[] = delegate.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(size[0], size[1]);
    }
}
