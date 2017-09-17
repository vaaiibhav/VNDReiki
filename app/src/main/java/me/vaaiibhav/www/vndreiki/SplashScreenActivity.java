package me.vaaiibhav.www.vndreiki;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas_screen);
        startAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent starter = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(starter);
                finish();
            }
        },3000);




    }


        private void startAnimation() {
            Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
            anim.reset();
            FrameLayout animframe=(FrameLayout)findViewById(R.id.anim_fram_layout);
            animframe.clearAnimation();
            animframe.startAnimation(anim);
            anim = AnimationUtils.loadAnimation(this,R.anim.translate);
            anim.reset();
            animframe.clearAnimation();
            animframe.startAnimation(anim);

    }
}
