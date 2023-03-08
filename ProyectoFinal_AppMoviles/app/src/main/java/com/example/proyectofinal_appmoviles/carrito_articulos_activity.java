package com.example.proyectofinal_appmoviles;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class carrito_articulos_activity extends Activity {

    ListView lv;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito_articulos);

        dbHandler = new DBHandler(carrito_articulos_activity.this);

        //SELECT SQLite
        String datos = dbHandler.selectProducto();
        String cuantos = datos.replaceAll("[^@]", "");
        int count = cuantos.length() + 1;
        String[] data = datos.split("@");

        carrito_articulos items_carrito[] = new carrito_articulos[count];
        for (int i = 0; i < count; i++) {
            items_carrito[i] = new carrito_articulos(
                    android.R.mipmap.sym_def_app_icon,
                    data[i].substring(0, data[i].indexOf("-")),
                    "$" + data[i].substring(data[i].indexOf("-") + 1, data[i].length()));
        }

        carrito_articulos_adapter adapter = new carrito_articulos_adapter(
                this,
                R.layout.carrito_articulos_listview_item_row,
                items_carrito);

        lv = (ListView) findViewById(R.id.carrito_articulos_listview);
        View header = (View) getLayoutInflater().inflate(R.layout.carrito_articulos_listview_header, null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String string_help = adapterView.getItemIdAtPosition(position) + "";

                if (string_help.equals("5")) {
                    //Intent intent = new Intent(Intent.ACTION_VIEW,
                    // Uri.parse("https://m.facebook.com/Sistemas-de-Bordados-169277673265428/?_rdr"));
                    //startActivity(intent);
                }
            }
        });
    }
}