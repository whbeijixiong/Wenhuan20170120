package com.bwei.wenhuan20170120.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bwei.wenhuan20170120.OtherActivity;
import com.bwei.wenhuan20170120.R;

/**
 * 作    者 ： 文欢
 * 时    间 ： 2017/2/20.
 * 描    述 ：
 * 修改时间 ：
 */

public class CircleView extends View {
    Paint paint;
    private int bigRadius;
    private int smallRadius;
    private int color;
    private int textsize;
    private String text;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化
        initAttrs(context,attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initAttrs(Context context,AttributeSet attrs) {
        //获取自定义属性
        TypedArray typedArtray = context.obtainStyledAttributes(attrs,R.styleable.CircleView);
        /**外圆半径*/
        bigRadius = (int)typedArtray.getDimension(R.styleable.CircleView_bigRadius,50);
        /** 内圆半径*/
        smallRadius = (int)typedArtray.getDimension(R.styleable.CircleView_smallRadius,30);
        /** 圆环颜色*/
        color = typedArtray.getColor(R.styleable.CircleView_color, Color.YELLOW);
        /** 字体大小*/
        textsize = (int) typedArtray.getDimension(R.styleable.CircleView_textsize,20);
        /** 字体*/
        text = typedArtray.getString(R.styleable.CircleView_text);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        //初始化画笔
        paint = new Paint();
        //设置画笔颜色
        paint.setColor(color);
        //绘制外圆
        canvas.drawCircle(getWidth()/2,getHeight()/2,bigRadius,paint);
        //设置字体大小 颜色
        paint.setTextSize(textsize);
        paint.setColor(Color.BLACK);
        //绘制文本内容  首先获取字体的宽,高
        Rect rect = new Rect();
        paint.getTextBounds(text,0,text.length(),rect);
        //获取文本的宽高
        int textWidth = rect.width();
        int textHeight = rect.height();

        //进行绘制
        canvas.drawText(text, getWidth()/2 - (textWidth /2), getHeight()/2 + (textHeight/2),paint);
    }
    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //获取按下时的位置
                int downX = (int) event.getX();
                int downY = (int) event.getY();
                //对位置进行判断
                judegDown(downX,downY);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void judegDown(int downX, int downY) {
        //根据勾股定理获取点击位置到圆中心点的距离来判断点击的位置
        int absX = Math.abs(getWidth()/2 - downX);
        int absY = Math.abs(getHeight()/2 - downY);
        double sqrt = Math.sqrt(absX * absX + absY * absY);
        //进行吐司提示
        if(sqrt <= bigRadius){
            Intent intent = new Intent(getContext(), OtherActivity.class);
            getContext().startActivity(intent);
        }
    }


}
