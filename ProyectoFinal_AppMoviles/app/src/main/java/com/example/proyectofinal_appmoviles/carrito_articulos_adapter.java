package com.example.proyectofinal_appmoviles;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class carrito_articulos_adapter extends ArrayAdapter<carrito_articulos> {
    Context context;
    int layoutResourceId;
    carrito_articulos data[] = null;

    public carrito_articulos_adapter(Context context, int layoutResourceId, carrito_articulos[] data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        carrito_articulos_holder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new carrito_articulos_holder();
            holder.imagen = (ImageView) row.findViewById(R.id.carrito_activity_image);
            holder.nombre = (TextView) row.findViewById(R.id.carrito_activity_textview1);
            holder.precio = (TextView) row.findViewById(R.id.carrito_activity_textview2);
            row.setTag(holder);
        } else {
            holder = (carrito_articulos_holder) row.getTag();
        }

        carrito_articulos articulos = data[position];
        holder.nombre.setText(articulos.nombre);
        holder.precio.setText(articulos.precio);
        holder.imagen.setImageResource(articulos.icon);
        return row;

    }

    static class carrito_articulos_holder {
        ImageView imagen;
        TextView nombre;
        TextView precio;
    }
}


