package com.example.urubambatours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 5000;

    Animation topAnim, bottomAnim;
    ImageView image, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.anim_logo);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.anim_titulo);

        image = findViewById(R.id.icono_splash);
        texto = findViewById(R.id.logo_splash);

        image.setAnimation(topAnim);
        texto.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_DELAY);

    }
}