package com.gincana.enti.entigincana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetallsPistaFragment extends Fragment {
    private View v;
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle savedInstanceState){
        v = inflador.inflate(R.layout.activity_detalls_pista_fragment, contenedor, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
    }
}
