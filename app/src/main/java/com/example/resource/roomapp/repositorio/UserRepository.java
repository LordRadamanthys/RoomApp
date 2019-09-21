package com.example.resource.roomapp.repositorio;

import android.content.Context;

import com.example.resource.roomapp.domain.User;
import com.example.resource.roomapp.infra.asyncTask.AsyncUser;
import com.example.resource.roomapp.ui.MainActivity;

import java.util.List;


public class UserRepository implements IUserRepository{


    @Override
    public void insert(Context c,User user) {
        AsyncUser task = new AsyncUser(c);
        task.execute(user);
    }

    @Override
    public void delete(User user) {
        MainActivity.myAppDataBase.myDao().deleteUser(user);
    }

    @Override
    public void alterar(User user) {
        MainActivity.myAppDataBase.myDao().updateUser(user);
    }

    @Override
    public List<User> listar() {
        return MainActivity.myAppDataBase.myDao().getAllUser();
    }


}
