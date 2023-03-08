package com.example.proyecto__unidad_2__appmovil.menu_3_barras;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto__unidad_2__appmovil.R;

public class menu_3_barras_activity extends Activity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_3_barras);

        menu_3_barras items_menu_3_barras[] = new menu_3_barras[]{
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Menú"),
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Categoria 1"),
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Categoria 2"),
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Categoria 3"),
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Categoria 4"),
                new menu_3_barras(android.R.mipmap.sym_def_app_icon, "Contactanos"),
        };

        menu_3_barras_adapter adapter = new menu_3_barras_adapter(this, R.layout.menu_3_barras_listview_item_row, items_menu_3_barras);

        lv = (ListView) findViewById(R.id.menu_3_barras_listview);
        View header = (View) getLayoutInflater().inflate(R.layout.menu_3_barras_listview_header, null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String string_help = adapterView.getItemIdAtPosition(position) + "";
                //TextView v = (TextView) view.findViewById(R.id.menu_3_barras_textview);
                //Toast.makeText(getApplicationContext(), string_help, Toast.LENGTH_SHORT).show();

                if (string_help.equals("5")) {
                    //Toast.makeText(getApplicationContext(), "HOLA", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/Sistemas-de-Bordados-169277673265428/?_rdr"));
                    startActivity(intent);
                }
            }
        });
    }
}