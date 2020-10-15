package com.example.learnwithfun.roomDataBase.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "app_opened")
public class AppOpenTime {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int openedTime;

    public AppOpenTime(int openedTime) {
        this.openedTime = openedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOpenedTime() {
        return openedTime;
    }

    public void setOpenedTime(int openedTime) {
        this.openedTime = openedTime;
    }
}
