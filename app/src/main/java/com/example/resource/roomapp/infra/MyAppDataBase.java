package com.example.resource.roomapp.infra;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.resource.roomapp.domain.User;
import com.example.resource.roomapp.infra.Dao.MyDao;

@Database(entities = {User.class},version = 1)
public abstract class MyAppDataBase extends RoomDatabase {


    public abstract MyDao myDao();


}
