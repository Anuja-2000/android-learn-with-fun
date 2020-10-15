package com.example.learnwithfun.roomDataBase.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserTime {
    @PrimaryKey(autoGenerate = true)
    private int id;

   private int viewCount;

    public UserTime(int viewCount) {
        this.viewCount = viewCount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
