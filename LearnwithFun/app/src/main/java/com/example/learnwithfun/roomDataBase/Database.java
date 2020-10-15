package com.example.learnwithfun.roomDataBase;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.learnwithfun.roomDataBase.dao.AppOpenTimeDao;
import com.example.learnwithfun.roomDataBase.dao.Dao;
import com.example.learnwithfun.roomDataBase.dao.UserTimeDao;
import com.example.learnwithfun.roomDataBase.entity.AppOpenTime;
import com.example.learnwithfun.roomDataBase.entity.UserTime;
import com.example.learnwithfun.roomDataBase.entity.Words;
import com.example.learnwithfun.util.LogUtil;
import com.example.learnwithfun.viewModel.InsertDataViewModel;

import java.util.List;

@androidx.room.Database(entities = {Words.class, UserTime.class, AppOpenTime.class}, version = 5, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract Dao dao();

    public abstract UserTimeDao userTimeDao();

    public abstract AppOpenTimeDao appOpenTimeDao();

    public static List<Words> list;
    public InsertDataViewModel insertDataViewModel;

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "word_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
//            new PopulateDbAsyncTask(instance).execute();
//            instance.insertDataViewModel = new  InsertDataViewModel(new Application());
//            instance.insertDataViewModel.insertData();
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            LogUtil.error("database ", "oncreate");

        }
    };

//    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private Dao dao;
//
//        private PopulateDbAsyncTask(Database db) {
//            dao = db.dao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            dao.deleteAll();
//            Words sinhalaWords1 = new Words(0, "Sinhala", "අ", "අම්මා", R.drawable.mother);
//            dao.insert(sinhalaWords1);
//            dao.insert(list);
//            return null;
//        }
//    }


}
