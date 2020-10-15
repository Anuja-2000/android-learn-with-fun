package com.example.learnwithfun.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.learnwithfun.roomDataBase.Database;
import com.example.learnwithfun.roomDataBase.dao.Dao;
import com.example.learnwithfun.roomDataBase.entity.Words;

import java.util.List;

public class MainActivityRepo {
    private Dao dao;
    private LiveData<List<Words>> wordList;
    private LiveData<List<String>> characterList;
    private LiveData<List<Words>> dataList;




    public MainActivityRepo(Application application) {
        Database database = Database.getInstance(application);
        dao = database.dao();
        wordList = dao.getData();
        characterList = new MediatorLiveData<>();


    }

    public void insert(List<Words> words) {
        dao.insert(words);
    }



    public LiveData<List<Words>> getWordList() {
        return wordList;
    }

    public void deleteall(){
        dao.deleteAll();
    }

    public LiveData<List<String>> getCharacterList(String  language) {
        characterList = dao.getCharacter(language);
        return characterList;
    }

    public LiveData<List<Words>> getDataList(String character) {
        dataList = dao.getAllData(character);
        return dataList;
    }
}
