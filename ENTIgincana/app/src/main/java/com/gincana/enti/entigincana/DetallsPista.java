package com.gincana.enti.entigincana;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Principal;

public class DetallsPista extends AppCompatActivity {

    private int indexLlista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalls_pista);

        Bundle extras = getIntent().getExtras();
        indexLlista = extras.getInt("listIndex");
        Hint h = HintList.getHintList().get(indexLlista);

        TextView hintTitle = (TextView)findViewById(R.id.hint_title);
        hintTitle.setText("Pista " + h.getIdentificator());

        TextView hintDescription = (TextView)findViewById(R.id.hint_description);
        hintDescription.setText(h.getDescription());

    }

    public void endActivity(View view){
        finish();
    }

    public void esborrar(View view){
        new AlertDialog.Builder(this)
                .setTitle("Esborrant pista")
                .setMessage("Segur que vols esborrar la pista?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HintList.getHintList().remove(indexLlista);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
