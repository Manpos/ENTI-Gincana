package com.gincana.enti.entigincana;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class EsborrarPistes extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esborrarpista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbarback);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    public void closeActivity(View view){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void esborrarPista(View view){
        final EditText identificador = (EditText)findViewById(R.id.id_esborrarpista);
        if(HintList.searchHint(Integer.parseInt(identificador.getText().toString())) != null){

            new AlertDialog.Builder(this)
                    .setTitle("Borrant pista")
                    .setMessage("Segur que vols borrar la pista?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            HintList.deleteHint(Integer.parseInt(identificador.getText().toString()));
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        else Toast.makeText(this, "No existeix cap pista amb aquest ID",Toast.LENGTH_SHORT).show();
    }


}

