package com.example.resource.roomapp.repositorio;

import android.content.Context;

import com.example.resource.roomapp.domain.User;

import java.util.List;


public interface IUserRepository {

    void insert(Context c, User user);

    void delete(User user);

    void alterar(User user);

    List<User> listar();

}
