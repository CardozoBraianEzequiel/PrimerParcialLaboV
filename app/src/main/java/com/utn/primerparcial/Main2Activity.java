package com.utn.primerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle("Modificar");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = super.getIntent().getExtras();


        EditText etNom = findViewById(R.id.etNombre);
        EditText etCant = findViewById(R.id.etCantidadProd);
        EditText etPrec = findViewById(R.id.etPrecioProd);
        TextView tvNom = findViewById(R.id.tvNombre);
        tvNom.setText(bundle.getString("Producto"));
        etNom.setText(bundle.getString("Producto"));
        etCant.setText(bundle.getString("Cantidad"));
        etPrec.setText(bundle.getString("Precio"));
        this.posicion=Integer.parseInt(bundle.getString("Posicion"));

        Button btn = super.findViewById(R.id.btnEditar);
        btn.setOnClickListener(new EditarProductoClick(this, posicion));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Log.d("Click en BACK", "Atras");
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
