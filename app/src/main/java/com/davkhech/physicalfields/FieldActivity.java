package com.davkhech.physicalfields;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FieldActivity extends Activity {

    private android.os.Handler customHandler = new android.os.Handler();
    private Paint p = new Paint();
    private MyRunnable draw = new MyRunnable();
    private Particle particle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        particle = new Particle();
        p.setAlpha(1);

        Bundle extras = getIntent().getExtras();

        String field = extras.getString(Constants.FIELD);

        TextView fieldName = (TextView) findViewById(R.id.field_name);
        fieldName.setText(field);


        draw.start();
    }

    private class MyRunnable implements Runnable {
        private Thread thread;

        @Override
        public void run() {
            LinearLayout layout = (LinearLayout) findViewById(R.id.particle);
            try {
                layout.removeViewAt(1);
            } catch (Exception e) {

            }
            layout.addView(new MyView(FieldActivity.this, null));
            Log.i("Runnable ---", "*********************");

            try {
                Thread.sleep(Constants.STEP_TIME);
                customHandler.post(draw);
            } catch (Exception e) {
                Log.e("Sleep exception -> ", String.valueOf(e));
            }
        }

        public void start() {
            Log.i("Thread", "Starting " + Constants.THREAD_NAME);
            if (thread == null) {
                thread = new Thread(this, Constants.THREAD_NAME);
                thread.start();
            }
        }
    }


    class MyView extends View {

        private Bitmap bm;

        public MyView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        public MyView(Context context, AttributeSet attrs) {
            super(context, attrs);
            bm = BitmapFactory.decodeResource(getResources(), R.drawable.facebook);
        }


        @Override
        public void onDraw(Canvas c) {
            super.onDraw(c);

            particle.update();

            c.drawBitmap(bm, particle.getxCoordinate(), particle.getyCoordinate(), null);
        }
    }
}
