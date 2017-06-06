package com.yundian.blackcard.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.yundian.blackcard.android.R;


/**
 * @author : created by chuangWu
 * @version : 0.01
 * @email : chuangwu127@gmail.com
 * @created time : 2016-01-07 13:35
 * @description : none
 * @for your attention : none
 * @revise : none
 */
public class MyProgressView extends ImageView {
    private float rotateDegrees;
    private int frameTime;
    private boolean needToUpdateView;
    private Runnable updateViewRunnable;

    public MyProgressView(Context context) {
        this(context, null);
    }

    public MyProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setImageResource(R.mipmap.ios_progress);
        frameTime = 1000 / 12;
        updateViewRunnable = new Runnable() {
            @Override
            public void run() {
                rotateDegrees += 30;
                rotateDegrees = rotateDegrees < 360 ? rotateDegrees : rotateDegrees - 360;
                invalidate();
                if (needToUpdateView) {
                    postDelayed(this, frameTime);
                }
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(rotateDegrees, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        needToUpdateView = true;
        post(updateViewRunnable);
    }

    @Override
    protected void onDetachedFromWindow() {
        needToUpdateView = false;
        super.onDetachedFromWindow();
    }
}
