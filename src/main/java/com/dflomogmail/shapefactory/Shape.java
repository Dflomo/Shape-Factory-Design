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
public abstract class Shape extends View{

    public Shape(Context context){
        super(context);
    }

    private void setShapeAlpha(float alpha){
        this.setAlpha(alpha);
    }
    public float getShapeAlpha(){
        return this.getAlpha();
    }
    public void removeShape(){
        this.setVisibility(GONE);
    }

    abstract String getShapeType();

//    @Override
    public abstract void onDraw(Canvas c);

}
