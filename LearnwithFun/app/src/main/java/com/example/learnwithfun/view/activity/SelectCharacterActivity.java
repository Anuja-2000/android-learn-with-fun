package com.example.learnwithfun.view.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.learnwithfun.R;
import com.example.learnwithfun.util.BackgroundMusicService;
import com.example.learnwithfun.view.adapter.CharacterListAdapter;
import com.example.learnwithfun.viewModel.SelectCharacterActivityViewModel;

import java.util.List;

public class SelectCharacterActivity extends AppCompatActivity {
    private SelectCharacterActivityViewModel selectCharacterActivityViewModel;
    private RecyclerView recyclerView;
    private CharacterListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String character;
    private static String language;
    private ActionBar actionBar;
    public static String title;
    public static int color;
    private LinearLayout backgroundLayout;
    private Intent backgroundMusicIntent;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);

        adapter = new CharacterListAdapter(this, getSupportFragmentManager());
        recyclerView = findViewById(R.id.rv_data_list);

        layoutManager = new GridLayoutManager(this, 4);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


        selectCharacterActivityViewModel = new ViewModelProvider(this).get(SelectCharacterActivityViewModel.class);

        selectCharacterActivityViewModel.getCharacterList(language).observe(this, new Observer<List<String>>() {

            @Override
            public void onChanged(List<String> strings) {
                Log.e("TAG", "onChanged: " + strings);
                adapter.setData(strings);
            }
        });

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            character = extras.getString(Constants.BUNDLE_CHARACTER);
//        }

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setColors(title, color);

    }

    public static void getLanguage(String language) {
        SelectCharacterActivity.language = language;

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setColors(String title, int color) {
        actionBar.setTitle(title);
        actionBar.setBackgroundDrawable(getDrawable(color));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().setNavigationBarColor(getColor(color));
            backgroundLayout = findViewById(R.id.select_character_activity_background);
            backgroundLayout.setBackgroundColor(getColor(color));
            getWindow().setStatusBarColor(getColor(color));
        }

//        actionBar.setBackgroundDrawable(getDrawable(R.color.white));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        backgroundMusicIntent = new Intent(this, BackgroundMusicService.class);
//        stopService(backgroundMusicIntent);
    }

}
