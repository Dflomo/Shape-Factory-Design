package com.dflomogmail.shapefactory;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    int cirCount = 0;
    int rectCount = 0;
    int triCount = 0;
    int count = 0;
    RelativeLayout mv;
    Vector<Shape> displayShapes = new Vector<>();
    TextView tv;

    public void alphaUpdate(){
        for(Shape temp: displayShapes){
            if(temp.getShapeAlpha() >= (float).8){
                temp.setAlpha(temp.getShapeAlpha() - (float).09);
            }
            else if((temp.getShapeAlpha() < (float).8) && (temp.getShapeAlpha() > .2)){
                temp.setAlpha(temp.getShapeAlpha() - (float) .3);
            }
            else if(temp.getShapeAlpha() <= (float).2){
                if(temp.getShapeType().equals("CIRCLE")){
                    if(cirCount <= 0){
                        cirCount = 0;
                    }
                    else {
                        cirCount--;
                    }
                }
                else if(temp.getShapeType().equals("RECTANGLE")){
                    if(rectCount <= 0){
                        rectCount = 0;
                    }
                    else {
                        rectCount--;
                    }
                }
                else{
                    if(triCount <= 0){
                        triCount = 0;
                    }
                    else {
                        triCount--;
                    }
                }
                temp.removeShape();

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = this.getApplicationContext();
        final RelativeLayout display = (RelativeLayout)findViewById(R.id.newLayout);
        tv = (TextView) findViewById(R.id.tv);
        mv = (RelativeLayout) findViewById(R.id.MainView);
        final ShapeFactory sf = new ShapeFactory();

        final MediaPlayer mediaCircle = MediaPlayer.create(context, R.raw.circle);
        final MediaPlayer mediaRect = MediaPlayer.create(context, R.raw.circle);
        final MediaPlayer mediaTri = MediaPlayer.create(context, R.raw.circle);
        final MediaPlayer mediaClear = MediaPlayer.create(context, R.raw.clear);

        final Button button1_Circle = (Button)findViewById(R.id.button1);
        final Button button2_Rectangle = (Button)findViewById(R.id.button2);
        final Button button3_Triangle = (Button)findViewById(R.id.button3);
        final Button button4_Clear = (Button)findViewById(R.id.button4);

        button1_Circle.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v) {
//                AssetFileDescriptor music;
//                try {
//                    music = getAssets().openFd("circle.mp3");
//                    mediaCircle.setDataSource(music.getFileDescriptor(), music.getStartOffset(), music.getLength());
//                    mediaCircle.prepare();
//                    mediaCircle.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                mediaCircle.start();
                Shape aCircle = sf.getShape(v.getContext(),"CIRCLE");
                displayShapes.add(aCircle);
                display.addView(aCircle);
                displayColorChange(mv);
                displayColorChange(display);
                alphaUpdate();
                cirCount++;
                countUpdate();
            }
        });

        button2_Rectangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaRect.start();
                Shape aRectangle = sf.getShape(v.getContext(),"RECTANGLE");
                displayShapes.add(aRectangle);
                display.addView(aRectangle);
                displayColorChange(mv);
                displayColorChange(display);
                alphaUpdate();
                rectCount++;
                countUpdate();
            }
        });
        button3_Triangle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mediaTri.start();
                Shape aTriangle = sf.getShape(v.getContext(),"TRIANGLE");
                displayShapes.add(aTriangle);
                display.addView(aTriangle);
                displayColorChange(mv);
                displayColorChange(display);
                alphaUpdate();
                triCount++;
                countUpdate();
            }
        });
        button4_Clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mediaClear.start();
                for(Shape temp: displayShapes){
                    temp.removeShape();
                }
                displayShapes.clear();
                cirCount = 0;
                rectCount = 0;
                triCount = 0;
                countUpdate();
                display.setBackgroundColor(Color.WHITE);
                mv.setBackgroundColor(Color.WHITE);
            }
        });

    }

    public RelativeLayout displayColorChange(RelativeLayout display){

        Random rand = new Random();
        int a = rand.nextInt(1000000);
        int b = rand.nextInt(1000000);
        int c = rand.nextInt(1000000);
        int color = Color.argb(255, a, b, c);
        display.setBackgroundColor(color);

        return display;
    }

    public void countUpdate(){

        String tempCountText = "Circles: " + cirCount + " Triangles: " + triCount + " Rectangles: " + rectCount;
        tv.setText(tempCountText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
