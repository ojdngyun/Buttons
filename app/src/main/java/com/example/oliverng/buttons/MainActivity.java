package com.example.oliverng.buttons;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

//git test

public class MainActivity extends ActionBarActivity {
    ImageView imageView;
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

//        int cx = (imageView2.getLeft() + imageView2.getRight()) / 2;
//        int cy = (imageView2.getTop() + imageView2.getBottom()) / 2;
//
//        int finalRadius = Math.max(imageView2.getWidth(), imageView2.getHeight());
//
//        Animator anim = ViewAnimationUtils.createCircularReveal(imageView2, cx, cy, 0, finalRadius);
//        anim.setInterpolator(new AccelerateInterpolator());
//        imageView2.setVisibility(View.VISIBLE);
//        anim.start();


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(imageView.getVisibility() == view.VISIBLE) {
                    if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        int cx = (int) motionEvent.getX();
                        int cy = (int) motionEvent.getY();

                        int initialRadius = imageView.getWidth();

                        // create the animation (the final radius is zero)
//                    Animator anim =
//                            ViewAnimationUtils.createCircularReveal(imageView, cx, cy, 1920, 0);

                        Animator anim = ViewAnimationUtils.createCircularReveal(imageView2, cx, cy, 0, 1920);

                        // make the view invisible when the animation is done
//                    anim.addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
//                            imageView.setVisibility(View.INVISIBLE);
//                            imageView2.setVisibility(View.VISIBLE);
//                        }
//                    });

                        imageView2.setVisibility(View.VISIBLE);
                        // start the animation
                        anim.setDuration(2000);
                        anim.setInterpolator(new AccelerateInterpolator());
                        anim.start();
                        imageView.setVisibility(View.INVISIBLE);

                    }
                }
                return true;
            }
        });

        imageView2.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    int cx = (int) motionEvent.getX();
                int cy = (int) motionEvent.getY();
                int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(imageView, cx, cy, 0, 1920);
//                    Animator anim2 = ViewAnimationUtils.createCircularReveal(imageView2, cx, cy, finalRadius, 0);


                imageView.setVisibility(View.VISIBLE);
                anim.setInterpolator(new AccelerateDecelerateInterpolator());
                anim.setDuration(2000);
                anim.start();

//                    anim2.start();
                imageView2.setVisibility(View.INVISIBLE);


                }
                return true;
            }
        });
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
        if (id == R.id.RevealActivity) {
            Intent intent = new Intent(MainActivity.this, TextReveal.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.ButtonActivity){
            Intent intent = new Intent(MainActivity.this, ButtonReveal.class);

        }

        return super.onOptionsItemSelected(item);
    }
}
