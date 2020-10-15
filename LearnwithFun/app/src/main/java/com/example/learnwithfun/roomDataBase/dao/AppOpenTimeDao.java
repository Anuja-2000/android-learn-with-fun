package com.example.learnwithfun.roomDataBase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learnwithfun.roomDataBase.entity.AppOpenTime;

@Dao
public interface AppOpenTimeDao {
    @Insert
    void save(AppOpenTime appOpenTime);

    @Update
    void update(AppOpenTime appOpenTime);

    @Query("select * from app_opened")
    AppOpenTime getAppOpenTime();

    @Query("update app_opened set openedTime = 0")
    void setZero();
}
