package com.dflomogmail.shapefactory;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by Sinchyman on 3/20/2016.
 */
public class ShapeFactory {

    public Shape getShape(Context context, String shapeType){
//        if(shapeType == null){
//            return null;
//        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle(context);
        }
        else if(shapeType.equalsIgnoreCase("TRIANGLE")){
            return new Triangle(context);
        }
        else {
            return new Rectangle(context);
        }
//        else if(shapeType.equalsIgnoreCase("TRIANGLE")){
//            return new Triangle();
//        }

    }
}

