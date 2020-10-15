package com.example.learnwithfun.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.learnwithfun.R;
import com.example.learnwithfun.roomDataBase.entity.Words;
import com.example.learnwithfun.util.Constants;
import com.example.learnwithfun.view.adapter.DataListAdapter;
import com.example.learnwithfun.viewModel.ShowWordsViewModel;

import java.util.List;

public class ShowWordsActivity extends AppCompatActivity {
    private Context context = this;
    private String character;
    private ShowWordsViewModel showWordsViewModel;
    private List<Words> dataList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DataListAdapter adapter;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_words);


        adapter = new DataListAdapter(context);

        recyclerView =findViewById(R.id.rv_word_list);
        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);


        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            character = extras.getString(Constants.BUNDLE_CHARACTER);
        }

        showWordsViewModel = new ViewModelProvider(this).get(ShowWordsViewModel.class);
        showWordsViewModel.getDataList(character).observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                dataList = words;
                Log.e("TAG", "onCreate: " + words.toString());
                adapter.setData(words);
            }
        });



    }

    public void openDialog() {
//        PopupDialogActivity popupDialogActivity = new PopupDialogActivity();
//        popupDialogActivity.show(getSupportFragmentManager(), "popup_dialog");
    }

}