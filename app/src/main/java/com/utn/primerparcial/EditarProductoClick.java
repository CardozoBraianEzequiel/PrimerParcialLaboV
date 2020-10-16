package com.utn.primerparcial;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EditarProductoClick implements View.OnClickListener {

    Main2Activity main2Activity;
    int posicion;

    public EditarProductoClick(Main2Activity main2Activity, int posicion) {
        this.main2Activity = main2Activity;
        this.posicion = posicion;
    }

    @Override
    public void onClick(View v) {
        EditText etNombre = main2Activity.findViewById(R.id.etNombre);
        EditText etCantidad = main2Activity.findViewById(R.id.etCantidadProd);
        EditText etPrecio = main2Activity.findViewById(R.id.etPrecioProd);
        Log.d("Llegue", etNombre.getText()+"");

        Intent i = new Intent(main2Activity, MainActivity.class);
        i.putExtra("Producto", etNombre.getText()+"");
        i.putExtra("Cantidad", etCantidad.getText()+"");
        i.putExtra("Precio", etPrecio.getText()+"");
        i.putExtra("Posicion", posicion+"");

        main2Activity.setResult(10, i);
        main2Activity.finish();


    }
}
