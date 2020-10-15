package com.example.learnwithfun.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.learnwithfun.repository.MainActivityRepo;
import com.example.learnwithfun.roomDataBase.entity.Words;

import java.util.List;

public class ShowWordsViewModel extends AndroidViewModel {
    private MainActivityRepo repository;
    private LiveData<List<Words>> dataList;
    public ShowWordsViewModel(@NonNull Application application) {
        super(application);
        repository = new MainActivityRepo(application);

    }

    public LiveData<List<Words>> getDataList(String character) {
        dataList = repository.getDataList(character);
        Log.e("TAG", "getDataList: "+dataList );
        return dataList;
    }
}
