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

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import java.security.Principal;

public class DetallsPista extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener {

    private GoogleApiClient apiClient;
    private GoogleMap mapa;
    private LocationRequest mLocationRequest;
    private static final long INTERVAL = 1000; //1 segundo
    private static final long FASTEST_INTERVAL = 1000; // 1 segundo
    private static final float SMALLEST_DISPLACEMENT = 0.05F;

    final int requestCode=0;
    private String proveedor;
    private LocationManager manejador;

    private int PETICION_PERMISO_LOCALIZACION=0;

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

        apiClient=new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mapaENTI);

        // Objecte que permet tractar els canvis de posició
        manejador = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criterio = new Criteria();
        criterio.setCostAllowed(false);
        criterio.setAltitudeRequired(false);
        criterio.setAccuracy(Criteria.ACCURACY_FINE);
        proveedor = manejador.getBestProvider(criterio, true);

    }

    @Override
    public void onStart()
    {
        super.onStart();

        /* Connexió al servidor de geolocalització */
        if (apiClient != null) {
            apiClient.connect();
        }

        /* Configuració de l'escoltador de posicions */
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setSmallestDisplacement(SMALLEST_DISPLACEMENT); //added
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        /* Si el permís està concedit, activar les escoltes de posició */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            manejador.requestLocationUpdates(proveedor, INTERVAL, SMALLEST_DISPLACEMENT, (android.location.LocationListener) this);
        }
        else {  /* Si no està concedit, demanar-lo a l'usuari */
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("Cal donar permis")
                        .setMessage("Necessito geolocalització")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ActivityCompat.requestPermissions(DetallsPista.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
                            }
                        })
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
            }
        }
    }
    /* Mètode que s'executa cada cop que es modifica la posició del dispositiu */
    public void onLocationChanged(Location location) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
            if (lastLocation==null)
                Toast.makeText(this, "No ha estat possible connectar", Toast.LENGTH_SHORT).show();
            else
            {
                /**** AQUEST MÈTODE ACTUALITZA LA INTERFICIE PER A MOSTRAR EN DOS TEXTVIEW LA LONGITUD I LATITUD ********/
                //s.updateUI(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
            }
        }
    }

    /* Mètode que s'executa quan es produeix la connexió */
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
            if (lastLocation==null)
                Toast.makeText(this, "No ha estat possible connectar", Toast.LENGTH_SHORT).show();
            else
            {
                /**** AQUEST MÈTODE ACTUALITZA LA INTERFICIE PER A MOSTRAR EN DOS TEXTVIEW LA LONGITUD I LATITUD ********/
                //s.updateUI(String.valueOf(lastLocation.getLatitude()), String.valueOf(lastLocation.getLongitude()));
            }
        }
    }


    public void onMapReady(GoogleMap p){
        mapa = p;
    }

    public void onProviderEnabled(String proveedor) {
        Toast.makeText(this,"Proveidor habilitat: " + proveedor + "\n", Toast.LENGTH_LONG).show();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(ConnectionResult result) {
    }

    public void onStatusChanged(String proveedor, int estado, Bundle extras) {
    }

    public void onProviderDisabled(String proveedor) {
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
