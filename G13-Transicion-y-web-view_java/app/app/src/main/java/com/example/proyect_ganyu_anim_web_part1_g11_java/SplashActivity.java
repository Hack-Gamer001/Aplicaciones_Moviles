package com.example.proyect_ganyu_anim_web_part1_g11_java;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN, android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // Agregar animaciones
        Animation animationUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation animationDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        TextView textViewSistemas = findViewById(R.id.textViewSistemas);
        TextView textView3de = findViewById(R.id.textView3de);
        View imageViewLogo = findViewById(R.id.imageViewlogo);

        textViewSistemas.setAnimation(animationUp);
        textView3de.setAnimation(animationDown);
        imageViewLogo.setAnimation(animationDown);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MotionActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}

