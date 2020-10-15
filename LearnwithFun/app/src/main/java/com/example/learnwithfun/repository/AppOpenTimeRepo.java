package com.example.learnwithfun.repository;

import android.content.Context;

import com.example.learnwithfun.roomDataBase.Database;
import com.example.learnwithfun.roomDataBase.entity.AppOpenTime;

public class AppOpenTimeRepo {
    private static Database database;

    public static int getCount(Context context){
        int currentCount = 0;
        if (database == null){
            database = Database.getInstance(context);
        }

        AppOpenTime appOpenTime = database.appOpenTimeDao().getAppOpenTime();

        if (appOpenTime == null){
            currentCount = 1;
            appOpenTime = new AppOpenTime(currentCount);
            database.appOpenTimeDao().save(appOpenTime);
        }else{
            currentCount = appOpenTime.getOpenedTime();
            currentCount++;
            appOpenTime.setOpenedTime(currentCount);
            database.appOpenTimeDao().update(appOpenTime);
        }
        return currentCount;
    }
    public static void setZero(Context context){
        if (database == null){
            database = Database.getInstance(context);
        }
        database.appOpenTimeDao().setZero();
    }
}
