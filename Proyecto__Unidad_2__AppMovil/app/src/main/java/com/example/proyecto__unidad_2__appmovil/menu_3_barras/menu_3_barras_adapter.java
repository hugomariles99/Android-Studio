package com.example.proyecto__unidad_2__appmovil.menu_3_barras;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto__unidad_2__appmovil.R;

public class menu_3_barras_adapter extends ArrayAdapter<menu_3_barras> {
    Context context;
    int layoutResourceId;
    menu_3_barras data[] = null;

    public menu_3_barras_adapter(Context context, int layoutResourceId, menu_3_barras[] data){
        super(context,layoutResourceId,data);
        this.context=context;
        this.layoutResourceId=layoutResourceId;
        this.data=data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row= convertView;
        menu_3_barras_holder holder=null;

        if(row==null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new menu_3_barras_holder();
            holder.imagen = (ImageView) row.findViewById(R.id.menu_3_barras_image);
            holder.texto = (TextView) row.findViewById(R.id.menu_3_barras_textview);
            row.setTag(holder);
        }
        else {
            holder = (menu_3_barras_holder) row.getTag();
        }

        menu_3_barras frutasVerduras =data[position];
        holder.texto.setText(frutasVerduras.title);
        holder.imagen.setImageResource(frutasVerduras.icon);
        return row;

    }

    static class menu_3_barras_holder {
        ImageView imagen;
        TextView texto;
    }
}


