package com.example.resource.roomapp.infra.asyncTask;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.resource.roomapp.domain.User;
import com.example.resource.roomapp.ui.MainActivity;


public class AsyncUser extends AsyncTask<User, Integer, String> {
    private Context c;

    public AsyncUser(Context c) {
        this.c = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(User... users) {
        if (users.length < 1) return "Vazio";

        for (int i = 0; i < users.length; i++) {
            MainActivity.myAppDataBase.myDao().addUser(users[i]);
            //publishProgress();
        }

        return "Cadastrado";
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        new AlertDialog.Builder(c).setTitle("AAAAAAA").setMessage(""+values).create().show();
    }
}
