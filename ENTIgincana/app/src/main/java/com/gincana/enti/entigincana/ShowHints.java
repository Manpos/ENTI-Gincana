package com.gincana.enti.entigincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShowHints extends AppCompatActivity {

    private Button btn_cancel, btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hints);

        Bundle extra = getIntent().getExtras();
        String s = extra.getString("description");

        btn_accept =(Button)findViewById(R.id.btn_showHAccept);
        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("resultat", "Operació acceptada");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btn_cancel =(Button)findViewById(R.id.btn_showHCancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("resultat", "Operació denegada");
                setResult(RESULT_CANCELED, i);
                finish();
            }
        });

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }



}
