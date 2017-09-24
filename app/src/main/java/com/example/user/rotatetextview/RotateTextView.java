package com.example.user.rotatetextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huqiang on 2017/9/17.
 */

public class RotateTextView extends View {
    private  int mWidth;
    private  int mHeight;
    public RotateTextView(Context context) {
        this(context,null);
    }

    public RotateTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        // 改变控件的宽高
        setMeasuredDimension(mHeight,mWidth);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 改变Canvas坐标系，使文字在竖直方向绘制
        canvas.translate(mHeight,0);
        canvas.rotate(90);

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLUE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(50);
        String message = getResources().getString(R.string.message);

        // 借助StaticLayout使文字能够自动换行
        StaticLayout myStaticLayout = new StaticLayout(message, textPaint, mWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        myStaticLayout.draw(canvas);
    }
}
