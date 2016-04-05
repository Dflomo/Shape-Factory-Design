package com.dflomogmail.shapefactory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Sinchyman on 3/20/2016.
 */
public class Rectangle extends Shape{

    Random rand;
    private String shapeType;

    public Rectangle(Context context){
        super(context);
        this.shapeType = "RECTANGLE";
        this.rand = new Random();
    }


    public void onDraw(Canvas c){

        //ALTERNATIVE WAY TO DEFINE A RECTANGLE
//        final int topEdge = rand.nextInt(c.getHeight());
//        final int leftEdge = rand.nextInt(c.getWidth());
//        final int bottomEdge = rand.nextInt(c.getWidth());
//        final int rightEdge = rand.nextInt(c.getHeight());
//
//        int color = Color.argb (255, topEdge, leftEdge, bottomEdge);
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(color);
//
//        c.drawRect(topEdge, leftEdge, bottomEdge , rightEdge, paint);

        int xPoint = rand.nextInt(c.getWidth()+100);
        int ran1 = (rand.nextInt(c.getHeight()+100)+xPoint);
        int ran2 = rand.nextInt(c.getWidth()+100);
        int upDown = rand.nextInt(100);
        Point a;
        Point b;
        Point d;
        Point e;

        if(upDown >= 50) {
            a = new Point(xPoint, xPoint);
            b = new Point(xPoint, ran1);
            d = new Point(ran1, ran1);
            e = new Point(ran1, xPoint);
        }
        else{
            a = new Point(ran1, ran1);
            b = new Point(ran1, xPoint);
            d = new Point(xPoint, xPoint);
            e = new Point(xPoint, ran1);
        }

        int color = Color.argb (255, xPoint, ran1, ran2);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(d.x, d.y);
        path.lineTo(e.x, e.y);
        path.lineTo(a.x, a.y);
        path.close();

        c.drawPath(path, paint);
    }

    public String getShapeType(){
        return shapeType;
    }
}
