package com.example.resource.roomapp.ui.AdapterUser;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resource.roomapp.repositorio.UserRepository;
import com.example.resource.roomapp.R;
import com.example.resource.roomapp.ui.UpdateActivity;
import com.example.resource.roomapp.domain.User;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolder> {

    private List<User> listaUsuarios;
    public Context context;

    public AdapterUser(List<User> lista) {
        this.listaUsuarios = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista_filmes, viewGroup, false);

        return new MyViewHolder(itemLista);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User itemUsuarios = listaUsuarios.get(i);
        myViewHolder.vincular(itemUsuarios);


    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }



    //inner class
    public class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener {

        TextView id;
        TextView nome;
        TextView email;
        User user;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textId);
            nome = itemView.findViewById(R.id.textNome);
            email = itemView.findViewById(R.id.textEmail);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void vincular(User user) {
            id.setText(String.format("id: %s", String.valueOf(user.getId())));
            nome.setText(String.format("Nome: %s", user.getName()));
            email.setText(String.format("Email: %s", user.getEmail()));

            this.user = user;
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem apagar = menu.add("Apagar");
            MenuItem editar = menu.add("Editar");

            apagar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String nome = user.getName();
                    user.iUserRepository = new UserRepository();
                    //MainActivity.myAppDataBase.myDao().deleteUser(user);
                    user.deletar();
                    listaUsuarios.remove(item.getItemId());
                    notifyItemRemoved(getAdapterPosition());
                    Toast.makeText(context, "Usuario: " + nome, Toast.LENGTH_SHORT).show();
                    return false;
                }
            });


            editar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    Intent editar = new Intent(context, UpdateActivity.class);
                    editar.putExtra("user", user);
                    context.startActivity(editar);

                    return false;
                }
            });
        }
    }
}
