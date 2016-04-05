package com.dflomogmail.shapefactory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Sinchyman on 3/20/2016.
 */
public class Triangle extends Shape {

    private Random rand = new Random();
    private Paint paint = new Paint();
    String shape_type = "TRIANGLE";


    public Triangle(Context context){
        super(context);
//        this.rand = new Random();
//        this.paint = new Paint();
    }

    @Override
    public void onDraw(Canvas c){


        int xPoint = rand.nextInt(c.getWidth()-100);
        int yPoint = rand.nextInt(c.getWidth()-100);
        int zPoint = rand.nextInt(c.getWidth()-100);
        int upDown = rand.nextInt(100);

        Point a = new Point(xPoint, zPoint);
        Point b;
        Point d;


        if(upDown >= 50) {
            b = new Point(xPoint+yPoint, xPoint+zPoint);
            d = new Point(xPoint + yPoint, zPoint);
        }
        else{
            b = new Point(xPoint+zPoint, xPoint+yPoint);
            d = new Point(zPoint, xPoint + yPoint);
        }

        int color = Color.argb (255, xPoint, yPoint, zPoint);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(d.x, d.y);
        path.lineTo(a.x, a.y);
        path.close();

        c.drawPath(path, paint);

    }

    @Override
    public String getShapeType() {
        return shape_type;
    }
}