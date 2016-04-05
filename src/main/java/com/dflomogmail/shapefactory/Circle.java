package com.dflomogmail.shapefactory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Sinchyman on 3/20/2016.
 */
public class Circle extends Shape {

    private Random rand = new Random();
    String shape_type = "CIRCLE";


    public Circle(Context context){
        super(context);
//        this.rand = new Random();
//        this.paint = new Paint();
    }

    @Override
    public void onDraw(Canvas c){

        final int x = rand.nextInt(c.getHeight()-50);
        final int y = rand.nextInt(c.getWidth()-50);
        final int z = rand.nextInt(c.getWidth()-400);

        int color = Color.argb (255, x, y, z);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        c.drawCircle(x, y, z, paint);

    }
    
    @Override
    public String getShapeType() {
        return shape_type;
    }
}
