package com.gincana.enti.entigincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addHints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_pista);
    }

    public void afegirNovaPista(View view){

        EditText identificador = (EditText)findViewById(R.id.addhint_identificador);
        Spinner tipuspista = (Spinner)findViewById(R.id.addhint_tipuspista);
        EditText descripcio = (EditText)findViewById(R.id.addhint_descripcio);
        EditText latitud = (EditText)findViewById(R.id.addhint_latitud);
        EditText longitud = (EditText)findViewById(R.id.addhint_longitud);
        EditText idseguent = (EditText)findViewById(R.id.addhint_idseguent);

        if(identificador.getText().toString().equals("") || descripcio.getText().toString().equals("") || latitud.getText().toString().equals("") || longitud.getText().toString().equals("") || idseguent.getText().toString().equals("") ){
            Toast.makeText(this, "Falten camps per emplenar", Toast.LENGTH_SHORT).show();
        }

        else if(HintList.searchHint(Integer.parseInt(identificador.getText().toString())) != null){
            Toast.makeText(this, "Ja hi ha una pista amb aquest ID", Toast.LENGTH_SHORT).show();
        }

        else{
            if(tipuspista.getSelectedItem() == tipuspista.getItemAtPosition(0)){
                HintList.addHint(new Image(Integer.parseInt(identificador.getText().toString()),
                        descripcio.getText().toString(),
                        Double.parseDouble(latitud.getText().toString()),
                        Double.parseDouble(longitud.getText().toString()),
                        Integer.parseInt(idseguent.getText().toString()),
                        "mada"));
            }
            else if(tipuspista.getSelectedItem().toString() == tipuspista.getItemAtPosition(2)){
                HintList.addHint(new Audio(Integer.parseInt(identificador.getText().toString()),
                        descripcio.getText().toString(),
                        Double.parseDouble(latitud.getText().toString()),
                        Double.parseDouble(longitud.getText().toString()),
                        Integer.parseInt(idseguent.getText().toString()),
                        "mada"));
            }
            else if(tipuspista.getSelectedItem().toString() == tipuspista.getItemAtPosition(1)){
                HintList.addHint(new Text(Integer.parseInt(identificador.getText().toString()),
                        descripcio.getText().toString(),
                        Double.parseDouble(latitud.getText().toString()),
                        Double.parseDouble(longitud.getText().toString()),
                        Integer.parseInt(idseguent.getText().toString()),
                        "mada"));
            }

        /*Toast.makeText(this, identificador.getText() + " "
                + tipuspista.getSelectedItem().toString()+ " "
                + descripcio.getText() + " "
                + latitud.getText() + " "
                + longitud.getText() + " "
                + idseguent.getText(),Toast.LENGTH_SHORT).show();*/

            //Toast.makeText(this, HintList.getSize(), Toast.LENGTH_SHORT).show();

            //finish();

            //Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();

            finish();
        }

    }

}
