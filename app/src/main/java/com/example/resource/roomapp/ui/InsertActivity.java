package com.example.resource.roomapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.resource.roomapp.R;
import com.example.resource.roomapp.domain.User;
import com.example.resource.roomapp.repositorio.UserRepository;

import java.util.Objects;


public class InsertActivity extends AppCompatActivity {

    EditText nome,email;
    Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Novo usuario");

        nome=findViewById(R.id.editNomeUpdate);
        email=findViewById(R.id.editEMail);
        btnSalvar = findViewById(R.id.btnSlavar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();

            }
        });

    }

    private void cadastrar() {
        User user = new User();

        user.setName(nome.getText().toString());
        user.setEmail(email.getText().toString());
        user.iUserRepository = new UserRepository();

        //MainActivity.myAppDataBase.myDao().addUser(user);

        //Toast.makeText(getApplicationContext(),"Cadastrado",Toast.LENGTH_SHORT).show();
        //AsyncUser teste = new AsyncUser();
        //teste.c = InsertActivity.this;
        //User[] u =  {user,user};
        user.context = this;
        user.inserir();
        clearFields();
    }

    private void clearFields() {
        nome.setText("");
        email.setText("");
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
