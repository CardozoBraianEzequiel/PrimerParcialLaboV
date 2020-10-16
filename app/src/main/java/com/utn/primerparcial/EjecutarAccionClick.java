package com.utn.primerparcial;

import android.content.Intent;
import android.util.Log;
import android.view.View;

public class EjecutarAccionClick implements View.OnClickListener {

    MainActivity mainActivity; //Para llamar al método
    int posicion; //posición del item de la lista que selecciona el usuario

    public EjecutarAccionClick(MainActivity mainActivity, int posicion) {
        this.mainActivity = mainActivity;
        this.posicion = posicion;
    }

    @Override
    public void onClick(View v) {
        //Identificar el boton presionado
        //Utilizar la View para recuperar los id !!

        Intent i = new Intent(mainActivity, Main2Activity.class);
        i.putExtra("Producto", mainActivity.getListaProductos().get(posicion).getNombre()+"");
        i.putExtra("Cantidad", mainActivity.getListaProductos().get(posicion).getCantidad()+"");
        i.putExtra("Precio", mainActivity.getListaProductos().get(posicion).getPrecio()+"");
        i.putExtra("Posicion", posicion+"");
        mainActivity.startActivity(i);

        Log.d("Click en opcion", "Item 1");

    }
}
