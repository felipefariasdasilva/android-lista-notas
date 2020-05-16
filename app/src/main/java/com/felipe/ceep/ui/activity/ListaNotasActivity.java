package com.felipe.ceep.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.felipe.ceep.R;
import com.felipe.ceep.dao.NotaDAO;
import com.felipe.ceep.model.Nota;
import com.felipe.ceep.ui.recyclerView.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        List<Nota> todasNotas = notasDeExemplo();
        configurarRecyclerView(todasNotas);
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeira Nota", "Descrição Pequena"));
        dao.insere(new Nota("Segunda Nota", "Segunda Descrição é Bem Maior Que a Primeira Nota"));
        return dao.todos();
    }

    private void configurarRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configurarAdapter(todasNotas, listaNotas);
    }

    private void configurarAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
