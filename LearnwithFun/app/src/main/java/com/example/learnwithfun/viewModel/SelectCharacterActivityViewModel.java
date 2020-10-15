package com.example.learnwithfun.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.learnwithfun.repository.MainActivityRepo;

import java.util.List;

public class SelectCharacterActivityViewModel extends AndroidViewModel {
    private MainActivityRepo repository;
    private LiveData<List<String>> characterList;



    public SelectCharacterActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new MainActivityRepo(application);

    }
    public LiveData<List<String>>getCharacterList(String language) {
        characterList = repository.getCharacterList(language);
        return characterList;
    }
}
