package com.example.learnwithfun.roomDataBase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learnwithfun.roomDataBase.entity.UserTime;

@Dao
public interface UserTimeDao {

    @Insert
    void save(UserTime user);

    @Update
    void update(UserTime user);

    @Query("select * from user")
    UserTime getUserTime();

    @Query("update user set viewCount = 0")
    void setViewCountToZero();

}
