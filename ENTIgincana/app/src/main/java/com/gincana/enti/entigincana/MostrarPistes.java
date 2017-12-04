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
import android.view.Menu;
import android.view.MenuItem;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
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

    // Menu configuration

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bar_menu_gestionarpistes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item_menu_gestionarpistes_esborrar){
            Intent i = new Intent(this, EsborrarPistes.class);
            startActivityForResult(i,0000);
            return true;
        }
        if(id == R.id.item_menu_exit){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Obrir activitats

    public void afegirPistes(View view){
        Intent i = new Intent(this, addHints.class);
        startActivity(i);
    }

    public void esborrarPistes(View view){
        Intent i = new Intent(this, EsborrarPistes.class);
        startActivityForResult(i,0000);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        adaptador.notifyDataSetChanged();
    }

    //Input sobre pistes

    public void onClick(View v){
        Intent i = new Intent(this, DetallsPista.class);
        i.putExtra("listIndex", recyclerView.getChildAdapterPosition(v));
        startActivityForResult(i,1111);
    }

    public boolean onLongClick(View v){
        esborrarPista(v);
        return true;
    }

    //Metodes per esborrar pistes

    private void esborrarPista(final View v){
        new AlertDialog.Builder(this)
                .setTitle("Borrant pista")
                .setMessage("Segur que vols borrar la pista?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HintList.getHintList().remove(recyclerView.getChildAdapterPosition(v));
                        adaptador.notifyDataSetChanged();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


}
