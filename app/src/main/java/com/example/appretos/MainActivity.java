package com.example.appretos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //declaracion publica del boton ingresar para acceder a la pantalla
    public Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //tiempo de duracion del splash screem capturado por un try cath//
        try {
            Thread.sleep(2000);//tiempo de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //carga de tema principal de la aplicacion y muestra en pantalla//
        setTheme(R.style.Theme_AppRetos);// vuelve al tema original
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamado e instanciado del button ingresar//
        btningresar = (Button) findViewById(R.id.btnIngresa);
    }
    //declaracion de metodo ingresar por vieew con intent para realizar la actividad//
    public void ingresar(View view){
        Intent ingresar = new Intent(this, Productos.class);
        startActivity(ingresar);

    }

}