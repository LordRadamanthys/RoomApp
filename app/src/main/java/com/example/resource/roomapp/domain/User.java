package com.example.resource.roomapp.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.resource.roomapp.repositorio.IUserRepository;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {

    @Ignore
    public IUserRepository iUserRepository;

    @Ignore
    public Context context;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void inserir(){
        iUserRepository.insert(context,this);
    }

    public void deletar(){
        iUserRepository.delete(this);
    }

    public void alterar(){
        iUserRepository.alterar(this);
    }


}
