package com.utn.primerparcial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Producto> listaProductos = new ArrayList<Producto>();;
    private ProductoAdapter productoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List<Producto> listaProductos
        listaProductos.add(new Producto("Television", 5, 15000));
        listaProductos.add(new Producto("Mesa", 20, 6050));
        listaProductos.add(new Producto("Xbox", 10, 16000));
        listaProductos.add(new Producto("Cuchillo", 100, 50.5));
        listaProductos.add(new Producto("Tenedor", 90, 50.5));
        listaProductos.add(new Producto("Plato", 24, 300));
        listaProductos.add(new Producto("Pava Electrica", 20, 950));
        listaProductos.add(new Producto("Silla Gamer", 30, 1200));
        listaProductos.add(new Producto("Sommier", 10, 23000));
        listaProductos.add(new Producto("Guitarra", 10, 901.5));
        listaProductos.add(new Producto("Mouse", 15, 250));
        listaProductos.add(new Producto("Teclado", 10, 850));

        this.listaProductos = listaProductos;

        RecyclerView recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ProductoAdapter productoAdapter = new ProductoAdapter(listaProductos, this);
        this.productoAdapter = productoAdapter;
        recyclerView.setAdapter(this.productoAdapter);

    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void ActualizarProducto(String nombre, String cantidad, String precio, int posicion){
        this.productoAdapter.ModificarProducto(nombre,cantidad,precio,posicion);
        this.productoAdapter.notifyItemChanged(posicion);
        //this.productoAdapter.notifyDataSetChanged();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.d("onActivityResul", "Llego");
        if(requestCode==10)
        {
            Log.d("onActivityResul", "Entro");
            Bundle bundle = data.getExtras();
            String producto = bundle.getString("Producto");
            String cantidad = bundle.getString("Cantidad");
            String precio = bundle.getString("Precio");
            String posicion = bundle.getString("Posicion");

            this.ActualizarProducto(producto, cantidad,precio, Integer.parseInt(posicion));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
