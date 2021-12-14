package com.example.appretos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Sucursales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales);
    }
    //creation del menu
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }

    //captura de acceso a los items del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos) {
            Intent intent = new Intent(getApplicationContext(), Productos.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Productos", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (id == R.id.servicios) {
            Intent intent = new Intent(getApplicationContext(), Servicios.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Servicios", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (id == R.id.sucursales) {
            Intent intent = new Intent(getApplicationContext(), Sucursales.class);
            Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Sucursales", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
       // if (id == R.id.carrito) {
       //     Intent intent = new Intent(getApplicationContext(), Carrito.class);
       //     Toast.makeText(getApplicationContext(), "Usted ha seleccionado la opción Compras", Toast.LENGTH_LONG).show();
       //     startActivity(intent);
       // }
        return super.onOptionsItemSelected(item);
    }

}