package com.example.oliverng.buttons;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by OliverNg on 4/21/2015.
 */
public class OnTapListener implements View.OnTouchListener{

    private final GestureDetector gestureDetector;
    private Context mContext;

    public OnTapListener(Context context){
        mContext = context;
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void OnTapConfirmed(){}

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            OnTapConfirmed();
            return false;
        }
    }
}
