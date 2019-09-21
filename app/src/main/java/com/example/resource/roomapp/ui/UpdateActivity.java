package com.example.resource.roomapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.resource.roomapp.R;
import com.example.resource.roomapp.domain.User;
import com.example.resource.roomapp.repositorio.UserRepository;

import java.util.Objects;

public class UpdateActivity extends AppCompatActivity {
    public EditText nome,email;
    public Button btnAtualizar;
    public TextView id;
    public User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Atualizar Usuario");

        nome = findViewById(R.id.editNomeUpdate);
        email = findViewById(R.id.editEmailUpdate);
        id = findViewById(R.id.editIdUpdate);
        btnAtualizar = findViewById(R.id.btnAtualizar);

        if(getIntent().hasExtra("user")){
             user = (User) Objects.requireNonNull(getIntent().getExtras()).getSerializable("user");

             id.setText(String.valueOf(user.getId()));
             nome.setText(user.getName());
             email.setText(user.getEmail());
        }

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizar();
            }
        });
    }

    private void atualizar() {

        user.setName(nome.getText().toString());
        user.setEmail(email.getText().toString());
        user.setId(Integer.parseInt(id.getText().toString()));
        user.iUserRepository = new UserRepository();
        //MainActivity.myAppDataBase.myDao().updateUser(user);
        user.alterar();
        finish();
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
