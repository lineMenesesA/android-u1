package com.example.holamundo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoAcceso extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Usar la clase Builder para crear el diálogo
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Crear una variable para apuntar e inflar el Layout
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflar y establecer el layout para el diálogo
        builder.setView(inflater.inflate(R.layout.dialogo_login,null))
                //========= BOTÓN POSITIVO ==================
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView tv = getActivity().findViewById(R.id.txtSaludo);
                        EditText etnom  = getDialog().findViewById(R.id.etUsuario);
                        EditText etpass = getDialog().findViewById(R.id.etPassword);

                        tv.setText("HOLA: "+etnom.getText());
                        etpass.getText();

                    }//onClick
                })//setPositiveButton
                //===========================================

                //======== BOTÓN NEGATIVO ================
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }//onClick
                });//setNegativeButton
        //========================================

        //return super.onCreateDialog(savedInstanceState);
        return  builder.create();
    }//onCreateDialog

}//clase
