package com.example.holamundo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    CharSequence items[]={"ITEM 1","ITEM 2","ITEM 3","ITEM 4","ITEM 5"};
    boolean marcados[]= new boolean[items.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Apuntar variables a componentes gráficos
        Button button = findViewById(R.id.btnDialogoItems);
        textView = findViewById(R.id.txtDialogoItems);

        //=== CREAR ESCUCHADORES
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder = builder.setIcon(R.mipmap.ic_launcher_round);
                builder.setTitle("Éste es un diálogo con Items")
                        //===== BOTÓN POSITIVO ==============
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(i == DialogInterface.BUTTON_POSITIVE){
                                    textView.setText("Ha seleccionado los ítems:");
                                    //Recorrer del arreglo marcados
                                    for(int j=0; j < marcados.length; j = j +1){
                                        if(marcados[j]){
                                            textView.append("\n"+items[j]);
                                        }//if
                                    }//for
                                }//if
                            }//onClick
                        })//setPositiveButton
                        //===================================
                        //======= BOTÓN NEGATIVO ==============
                        .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }//onClick
                        })//setNegativeButton
                        //=====================================
                        //********* ESTABLECER LOS ITEMS DEL CUADRO DE DIÁLOGO *********************
                        .setMultiChoiceItems(items, marcados, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if(b){
                                    marcados[i]= true;
                                }
                                else{
                                    marcados[i]= false;
                                }//else

                            }//onClick
                        });//setMultiChoiceItems
                //**************************************************************************

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }//onClick
        });//setOnClickListener

    }//onCreate
}

