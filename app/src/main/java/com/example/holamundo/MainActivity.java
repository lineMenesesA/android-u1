package com.example.holamundo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Apuntar variables a componentes gráficos
        Button btn_dialogo = findViewById(R.id.btnMostrarDialogo);
        textView = findViewById(R.id.txtBotonPulsado);


        //Crear escuchadores
        btn_dialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variable para generar un objeto tipo cuadro de diálogo
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //Establecer carácterísticas del cuadro de diálogo
                builder.setTitle("Este es un diálogo con botones");
                builder.setMessage("Desea salir del sistema?");
                builder.setCancelable(false);//impide salir del mensaje con el botón de retroceso

                //Establecer los escuchadores para los botones del cuadro de diálogo

                //===== BOTÓN POSITIVO =====================================================
                builder.setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Botón SÍ pulsado");
                        MainActivity.this.finish();
                    }//onClick
                });//setPositiveButton
                //===========================================================================

                //===== BOTÓN NEUTRAL =====================================================
                builder.setNeutralButton("Botón Neutro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Botón Neutro pulsado");
                    }//onClick
                });//setNeutralButton
                //==========================================================================

                //===== BOTÓN NEGATIVO =====================================================
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Botón NO pulsado");
                        dialogInterface.cancel();
                    }//onClick
                });//setNegativeButton
                //==========================================================================

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }//onClick
        });//btn_dialogo.setOnClickListener

    }//onCreate

}//MainActivity