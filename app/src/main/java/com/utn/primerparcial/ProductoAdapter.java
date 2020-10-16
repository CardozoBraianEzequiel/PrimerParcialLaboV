package com.utn.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    private List<Producto> listaProductos;
    private MainActivity mainActivity;

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public ProductoAdapter(List<Producto> listaProductos, MainActivity mainActivity) {
        this.listaProductos = listaProductos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_layout, parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(v);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        //Setear los elementos de la view con los datos del objeto
        Producto producto = listaProductos.get(position); //uso la posición para encontrar el item

        //TODO pasar a string los valores
        holder.tvNombre.setText(producto.getNombre());
        holder.tvCantidadProd.setText(Integer.valueOf(producto.getCantidad()).toString());
        holder.tvPrecioProd.setText(Double.valueOf(producto.getPrecio()).toString());

        //Pasar activity
        EjecutarAccionClick ejecutarAccionClick = new EjecutarAccionClick(this.mainActivity, position);
        holder.itemView.setOnClickListener(ejecutarAccionClick);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void ModificarProducto(String nombre, String cantidad, String precio, int posicion){
        this.listaProductos.get(posicion).setNombre(nombre);
        this.listaProductos.get(posicion).setCantidad(Integer.parseInt(cantidad));
        this.listaProductos.get(posicion).setPrecio(Double.parseDouble(precio));
    }
}
