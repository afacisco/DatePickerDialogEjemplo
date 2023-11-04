package com.example.datepickerdialogejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/*
Autor: Juan Francisco Sánchez González
Fecha: 04/11/2023
Clase: Actividad principal con un botón que muestra un diálogo DatePickerDialog, y al pulsar Aceptar en él
se lanza un Toast con la fecha elegida.
*/

public class MainActivity extends AppCompatActivity {

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia del Calendario del sistema
        final Calendar calen = Calendar.getInstance();
        int year = calen.get(Calendar.YEAR);
        int month = calen.get(Calendar.MONTH);
        int day = calen.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog fecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            // Escuchador del DatePickerDialog
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // Toast que muestra la fecha seleccionada
                Toast.makeText(getApplicationContext(), String.valueOf(i2) + "/" + String.valueOf(i1) + "/" + String.valueOf(i), Toast.LENGTH_LONG).show();
            }
        }, year, month, day);


        boton = (Button) findViewById(R.id.button);
        // Evento del botón, que muestra el DatePickerDialog
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fecha.show();
            }
        });
    }
}