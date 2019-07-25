package com.example.menufloating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab_plus,fab_mobile,fab_alert;
    Animation FabOpen,FabClose,FabClock,FabAnti;
    boolean isOpen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab_plus = findViewById(R.id.fab_plus);
        fab_mobile = findViewById(R.id.fab_mobile);
        fab_alert = findViewById(R.id.fab_alert);

        fab_mobile.setOnClickListener(this);
        fab_alert.setOnClickListener(this);


        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close);
        FabClock = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotateclock);
        FabAnti = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anticlock);


        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen){
                    fab_mobile.startAnimation(FabClose);
                    fab_alert.startAnimation(FabClose);
                    fab_plus.startAnimation(FabAnti);
                    fab_mobile.setClickable(false);
                    fab_alert.setClickable(false);
                    isOpen = false;
                }
                else {
                    fab_mobile.startAnimation(FabOpen);
                    fab_alert.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabClock);
                    fab_mobile.setClickable(true);
                    fab_alert.setClickable(true);
                    isOpen = true;
                }


            }
        });








    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.fab_mobile:
                Toast.makeText(this, "Mobile menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_alert:
                Toast.makeText(this, "Alert menu", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }



    }
}
