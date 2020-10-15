package com.example.learnwithfun.view.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.learnwithfun.R;
import com.example.learnwithfun.repository.AppOpenTimeRepo;
import com.example.learnwithfun.viewModel.InsertDataViewModel;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
    private InsertDataViewModel insertDataViewModel = null;
    private String TAG = " MainActivity";
    private Context context;
    private LottieAnimationView lottieAnimationView;
    private ActionBar actionBar;
    private final int MAX_APP_OPENED_TIME = 1;
    private boolean isOntouch;
    private boolean isOnCreate = false;
    private RelativeLayout mainActivityLayout;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;
        isOnCreate = true;
        actionBar = getSupportActionBar();
        actionBar.hide();

        mainActivityLayout = findViewById(R.id.main_activity_layout);

        lottieAnimationView = findViewById(R.id.animation_view_splash);
        lottieAnimationView.playAnimation();

//        AppOpenTimeRepo.setZero(context);

        if (AppOpenTimeRepo.getCount(context) == MAX_APP_OPENED_TIME) {
//            LogUtil.error("MainActivity",String.valueOf(AppOpenTimeRepo.getCount(context)));
            insertDataViewModel = new ViewModelProvider(this).get(InsertDataViewModel.class);
            insertDataViewModel.insertData();
        }

        if (insertDataViewModel == null) {
            Log.e(TAG, "onCreate: " + insertDataViewModel);
        }

        Stetho.initializeWithDefaults(context);

        Log.d("main activity", String.valueOf(lottieAnimationView.isAnimating()));


        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                lottieAnimationView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                lottieAnimationView.setVisibility(View.GONE);
                if (!isOntouch) {
                    goToSelectLanguageActivity();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        getWindow().setStatusBarColor(getColor(R.color.White));

        mainActivityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectLanguageActivity();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);

        if (!isOnCreate) {
            goToSelectLanguageActivity();
        }
    }

    public void goToSelectLanguageActivity() {
        Intent intent = new Intent(context, SelectLanguageActivity.class);
        startActivity(intent);
        finish();
    }
}