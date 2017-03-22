package com.talon.easycustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Talon on 2017/3/22.
 */

public class ThemeCustomView extends View {

    private int mColor0;
    private int mColor1;
    private int mColor2;
    private int mColor3;

    private Rect rect0;
    private Rect rect1;
    private Rect rect2;
    private Rect rect3;

    private Paint mPaint = new Paint();

    public ThemeCustomView(Context context) {
        this(context, null);
    }

    public ThemeCustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        setWillNotDraw(false);
    }

    public ThemeCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ThemeCustomView, 0, 0);
        try {
            mColor0 = typedArray.getColor(R.styleable.ThemeCustomView_color0, 0);
            mColor1 = typedArray.getColor(R.styleable.ThemeCustomView_color1, 0);
            mColor2 = typedArray.getColor(R.styleable.ThemeCustomView_color2, 0);
            mColor3 = typedArray.getColor(R.styleable.ThemeCustomView_color3, 0);
        } catch (Exception e) {
            Log.e("ThemeCustomView", e.getMessage(), e);
        } finally {
            typedArray.recycle();
        }
        initPaint();
    }

    private void initPaint() {
        mPaint.setAntiAlias(true); //设置抗锯齿的效果
        mPaint.setStyle(Paint.Style.FILL); //设置画笔样式为填充
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = 200;
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, widthSize);
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = 200;
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, heightSize);
            }
        }

        rect0 = new Rect(0, 0, width / 2, height / 2);
        rect1 = new Rect(width / 2, 0, width, height / 2);
        rect2 = new Rect(0, height / 2, width / 2, height);
        rect3 = new Rect(width / 2, height / 2, width, height);
        Log.i("Talon", width + "," + height);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        rect0 = new Rect(0, 0, 100, 100);
        Log.i("Talon", "" + mColor0);
        mPaint.setColor(mColor0);
        canvas.drawRect(rect0, mPaint);
        mPaint.setColor(mColor1);
        canvas.drawRect(rect1, mPaint);
        mPaint.setColor(mColor2);
        canvas.drawRect(rect2, mPaint);
        mPaint.setColor(mColor3);
        canvas.drawRect(rect3, mPaint);
        canvas.save();
    }

    public int[] getColors() {
        return new int[]{mColor0, mColor1, mColor2, mColor3};
    }

    public void setColors(int[] colors) {
        if (colors.length > 3) {
            mColor0 = colors[0];
            mColor1 = colors[1];
            mColor2 = colors[2];
            mColor3 = colors[3];
        }
        invalidate();
    }
}
