package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // todo 10. 练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int[] heights = new int[]{10, 50, 100, 150, 300, 200, 260};
        String[] names = new String[]{"A", "B", "C", "D", "E", "F", "G"};

        int width = 80;
        int interval = 20;
        int left = 150;
        int bottom = 500;
        for (int i = 0; i < heights.length; i++){
            paint.setColor(Color.GREEN);
            int top = bottom - heights[i];
            left += interval;
            int right = left + width;
            canvas.drawRect(left, top, right, bottom, paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            canvas.drawText(names[i], left + 30, bottom + 40, paint);
            left = right;
        }

        paint.setStrokeWidth(2);
        paint.setColor(Color.WHITE);
        canvas.drawLine(150, 50, 150, 500, paint);
        canvas.drawLine(150, 500, 900, 500, paint);
    }
}
