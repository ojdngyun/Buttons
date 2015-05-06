package com.example.oliverng.buttons;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;


public class ButtonReveal extends ActionBarActivity {

    Button mButton1;
    Button mButton2;
    View mView1;
    View mView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_reveal);

        mButton1 = (Button) findViewById(R.id.button2);
        mButton2 = (Button) findViewById(R.id.button3);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator anim = ViewAnimationUtils.createCircularReveal(mButton2, 0, 0, 0, 1080);
                mButton2.setVisibility(View.VISIBLE);
                anim.setDuration(2000);
                anim.start();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator anim = ViewAnimationUtils.createCircularReveal(mButton1, 0, 0, 0, 1080);
                mButton1.setVisibility(View.VISIBLE);
                anim.setDuration(2000);
                anim.start();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button_reveal, menu);
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
