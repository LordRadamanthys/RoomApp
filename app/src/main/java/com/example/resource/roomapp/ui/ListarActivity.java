package com.example.resource.roomapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.resource.roomapp.ui.AdapterUser.AdapterUser;
import com.example.resource.roomapp.R;
import com.example.resource.roomapp.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListarActivity extends AppCompatActivity {
    RecyclerView recyclerUser;
    public AdapterUser adp;
    List<User> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Lista de Usuarios");

        recyclerUser = findViewById(R.id.recyclerView);
        this.listaUsuarios = MainActivity.myAppDataBase.myDao().getAllUser();
        //COnfigurando adapter
        adp = new AdapterUser(listaUsuarios);
        adp.context = this;


        recyclerUser.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));//define separador entre as views

        recyclerUser.setAdapter(adp);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //listaUsuarios.clear();

        adp.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
