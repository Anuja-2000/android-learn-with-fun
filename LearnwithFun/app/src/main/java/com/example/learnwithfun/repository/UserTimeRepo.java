package com.example.learnwithfun.repository;

import android.content.Context;

import com.example.learnwithfun.roomDataBase.Database;
import com.example.learnwithfun.roomDataBase.entity.UserTime;

public class UserTimeRepo {

    private static Database database;

    public static int getCount(Context context){
        int currentCount = 0;
        if(database ==null){
            database = Database.getInstance(context);
        }

        UserTime userTime = database.userTimeDao().getUserTime();

        if(userTime ==null){
            currentCount = 1;
            userTime = new UserTime(currentCount);
            database.userTimeDao().save(userTime);
        }else {
           currentCount = userTime.getViewCount();
            currentCount++;
            userTime.setViewCount(currentCount);
            database.userTimeDao().update(userTime);
        }

        return currentCount;



    }

    public static void setZero(){
        database.userTimeDao().setViewCountToZero();
    }

}
