package com.gincana.enti.entigincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HintList.addHint(new Image(1, "Pista de prova 1", 88.66, 66.88,2,"mada"));
        HintList.addHint(new Audio(2, "Pista de prova 2", 88.66, 66.88,3,"mada"));
        HintList.addHint(new Text(3, "Pista de prova 3", 88.66, 66.88,4,"mada"));

        setContentView(R.layout.activity_main);
        //setContentView(R.layout.afegir_pista);
    }

    public void mostrarPistes(View view){
        Intent i  = new Intent(this, MostrarPistes.class);
        startActivity(i);
    }

    public void ShowAbout(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item_menu_about){
            Intent i = new Intent(this, About.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.item_menu_exit){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        /*if(requestCode == 8888 && resultCode == RESULT_OK){
            String res = data.getExtras().getString("resultat");
            Toast.makeText(this,res,Toast.LENGTH_SHORT).show();
        }
        if(requestCode == 8888 && resultCode == RESULT_CANCELED){
            String res = data.getExtras().getString("resultat");
            Toast.makeText(this,res,Toast.LENGTH_SHORT).show();
        }*/
    }

    /*public void showHints(View view){
        Intent i = new Intent(this, MostrarPistes.class);
        startActivity(i);
    }*/

}

