package com.gincana.enti.entigincana;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarPistes extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pistes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.showhints_toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adaptador = new Adaptador(this, HintList.getHintList());
        adaptador.setOnClickListener(this);
        adaptador.setOnLongClickListener(this);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afegirPistes(view);
            }
        });
    }

    public void afegirPistes(View view){
        Intent i = new Intent(this, addHints.class);
        startActivity(i);
    }

    public void onClick(View v){

        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public boolean onLongClick(View v){
        final View currentView = v;
        new AlertDialog.Builder(this)
                .setTitle("Borrant pista")
                .setMessage("Segur que vols borrar la pista?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HintList.getHintList().remove(recyclerView.getChildAdapterPosition(currentView));
                        adaptador.notifyDataSetChanged();
                    }

                })
                .setNegativeButton("No", null)
                .show();

        Toast.makeText(this, "long click" , Toast.LENGTH_SHORT).show();
        return true;
    }

}
