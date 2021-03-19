package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//jacque
public class ActividadDialogoAcceso extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dialogo_acceso);

        //Invocar al cuadro de diálogo a través del administrador de Fragmentos
        new DialogoAcceso().show(getSupportFragmentManager(),"DialogoAcceso");

    }//onCreate
}//main