package com.example.learnwithfun.roomDataBase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnwithfun.roomDataBase.entity.Words;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(List<Words> words);

    @Query("select * from data_table ")
    LiveData<List<Words>> getData();

    @Query("delete from data_table")
    void deleteAll();

    @Query("select distinct character from data_table where language=:language")
    LiveData<List<String>> getCharacter(String language);

    @Query("select * from data_table where character=:character")
    LiveData<List<Words>> getAllData(String character);
}
