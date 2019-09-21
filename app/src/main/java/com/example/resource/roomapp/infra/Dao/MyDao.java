package com.example.resource.roomapp.infra.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.resource.roomapp.domain.User;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
     void addUser(User user);

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Delete
     void deleteUser(User user);

    @Update
     void updateUser(User user);



}
