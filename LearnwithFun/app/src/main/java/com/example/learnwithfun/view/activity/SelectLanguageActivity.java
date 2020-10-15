package com.example.learnwithfun.view.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learnwithfun.R;
import com.example.learnwithfun.util.BackgroundMusicService;
import com.example.learnwithfun.util.ButtonClickSoundService;
import com.example.learnwithfun.util.Constants;
import com.example.learnwithfun.util.LogUtil;
import com.example.learnwithfun.view.adapter.CharacterListAdapter;

public class SelectLanguageActivity extends AppCompatActivity {
    private TextView lblLanguageSinhala;
    private TextView lblLanguageEnglish;
    private TextView lblLanguageTamil;
    private TextView lblLanguageNumbers;
    private Context context;
    private ActionBar actionBar;
    private Intent intentService;
    private Intent btnSoundServiceIntent;
    private MediaPlayer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        context = this;

        mediaPlayer = MediaPlayer.create(context,R.raw.music);

        lblLanguageSinhala = findViewById(R.id.lbl_language_sinhala);
        lblLanguageEnglish = findViewById(R.id.lbl_language_english);
        lblLanguageTamil = findViewById(R.id.lbl_language_tamil);
        lblLanguageNumbers = findViewById(R.id.lbl_language_numbers);

        actionBar = getSupportActionBar();
        actionBar.hide();

        lblLanguageSinhala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage(Constants.LANGUAGE_SINHALA, R.color.colorLanguageSinhala, Constants.TITLE_SINHALA_LANGUAGE, R.color.colorSinhalaBackground);
            }
        });

        lblLanguageEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage(Constants.LANGUAGE_ENGLISH, R.color.colorLanguageEnglish, Constants.TITLE_ENGLISH_LANGUAGE, R.color.colorEnglishBackground);
            }
        });

        lblLanguageTamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage(Constants.LANGUAGE_TAMIL, R.color.colorLanguageTamil, Constants.TITLE_TAMIL_LANGUAGE, R.color.colorTamilBackground);

            }
        });

        lblLanguageNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLanguage(Constants.NUMBERS, R.color.colorLanguageNumbers, Constants.TITLE_NUMBERS, R.color.colorNumbersBackground);
            }
        });


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getColor(R.color.colorselectLangugeActivityBarColours));
        }
        getWindow().setStatusBarColor(getColor(R.color.colorselectLangugeActivityBarColours));

        intentService = new Intent(this, BackgroundMusicService.class);
        startService(intentService);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (!mediaPlayer.isPlaying()){
//            LogUtil.error("selectLanguage",String.valueOf(mediaPlayer.isPlaying()));
//            startService(intentService);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intentService);
    }


    private void setLanguage(String language, int color, String actionbarTitle, int background) {

        btnSoundServiceIntent = new Intent(this,ButtonClickSoundService.class);
        startService(btnSoundServiceIntent);

        SelectCharacterActivity.title = actionbarTitle;
        SelectCharacterActivity.color = background;
        SelectCharacterActivity.getLanguage(language);
        CharacterListAdapter.setColourID(getResources().getColor(color));
        gotoActivity();
    }

    public void gotoActivity() {
        Intent intent = new Intent(this, SelectCharacterActivity.class);
        startActivity(intent);
    }


}