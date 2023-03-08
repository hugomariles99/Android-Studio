package com.example.proyectofinal_appmoviles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InventarioActivity extends AppCompatActivity {

    private EditText ins_id_producto, ins_nombre_producto, ins_precio_producto,
            ins_categoria_producto, ins_stock_producto,
            del_producto,
            upd_id_producto, upd_nombre_producto, upd_precio_producto,
            upd_categoria_producto, upd_stock_producto;

    private Button botonInsert, botonDelete, botonUpdate,
            botonINS, botonDEL, botonUPD;

    private LinearLayout bannerINS, bannerDEL, bannerUPD;

    private boolean flag_INS = false, flag_DEL = false, flag_UPD = false;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventario);

        ins_id_producto = findViewById(R.id.insert_id_producto);
        ins_nombre_producto = findViewById(R.id.insert_nombre_producto);
        ins_precio_producto = findViewById(R.id.insert_precio_producto);
        ins_categoria_producto = findViewById(R.id.insert_categoria_producto);
        ins_stock_producto = findViewById(R.id.insert_stock_producto);
        botonInsert = findViewById(R.id.boton_insertProducto);

        del_producto = findViewById(R.id.delete_producto);
        botonDelete = findViewById(R.id.boton_deleteProducto);

        upd_id_producto = findViewById(R.id.update_id_producto);
        upd_nombre_producto = findViewById(R.id.update_nombre_producto);
        upd_precio_producto = findViewById(R.id.update_precio_producto);
        upd_categoria_producto = findViewById(R.id.update_categoria_producto);
        upd_stock_producto = findViewById(R.id.update_stock_producto);
        botonUpdate = findViewById(R.id.boton_updateProducto);

        bannerINS = (LinearLayout) findViewById(R.id.insert_banner);
        botonINS = findViewById(R.id.insert_boton_layout);
        bannerDEL = (LinearLayout) findViewById(R.id.delete_banner);
        botonDEL = findViewById(R.id.delete_boton_layout);
        bannerUPD = (LinearLayout) findViewById(R.id.update_banner);
        botonUPD = findViewById(R.id.update_boton_layout);

        dbHandler = new DBHandler(InventarioActivity.this);

        //dbHandler.createProductos();

        //dbHandler.fillDatabase();

        //INSERT SQLite
        botonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = ins_id_producto.getText().toString();
                String nombre = ins_nombre_producto.getText().toString();
                String precio = ins_precio_producto.getText().toString();
                String categoria = ins_categoria_producto.getText().toString();
                String stock = ins_stock_producto.getText().toString();

                dbHandler.insertProducto(id, nombre, precio, categoria, stock);

                Toast.makeText(InventarioActivity.this, "Producto agregado", Toast.LENGTH_SHORT).show();

                ins_id_producto.setText("");
                ins_nombre_producto.setText("");
                ins_precio_producto.setText("");
                ins_categoria_producto.setText("");
                ins_stock_producto.setText("");
            }
        });

        //DELETE SQLite
        botonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delete = del_producto.getText().toString();

                boolean flag = dbHandler.deleteProducto(delete);

                Toast.makeText(InventarioActivity.this, "Producto eliminado", Toast.LENGTH_SHORT).show();

                del_producto.setText("");
            }
        });

        //UPDATE SQLite
        botonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = upd_id_producto.getText().toString();
                String nombre = upd_nombre_producto.getText().toString();
                String precio = upd_precio_producto.getText().toString();
                String categoria = upd_categoria_producto.getText().toString();
                String stock = upd_stock_producto.getText().toString();

                dbHandler.updateProducto(id, nombre, precio, categoria, stock);

                Toast.makeText(InventarioActivity.this, "Producto actualizado", Toast.LENGTH_SHORT).show();

                upd_id_producto.setText("");
                upd_nombre_producto.setText("");
                upd_precio_producto.setText("");
                upd_categoria_producto.setText("");
                upd_stock_producto.setText("");
            }
        });

        //Show/Hide Banner INS
        botonINS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideINS();
            }
        });

        //Show/Hide Banner DEL
        botonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideDEL();
            }
        });

        //Show/Hide Banner UPD
        botonUPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideUPD();
            }
        });
    }

    public void hideINS() {
        if (flag_INS) {
            bannerINS.setVisibility(View.VISIBLE);
            flag_INS = false;
        } else {
            bannerINS.setVisibility(View.GONE);
            flag_INS = true;
        }
    }

    public void hideDEL() {
        if (flag_DEL) {
            bannerDEL.setVisibility(View.VISIBLE);
            flag_DEL = false;
        } else {
            bannerDEL.setVisibility(View.GONE);
            flag_DEL = true;
        }
    }

    public void hideUPD() {
        if (flag_UPD) {
            bannerUPD.setVisibility(View.VISIBLE);
            flag_UPD = false;
        } else {
            bannerUPD.setVisibility(View.GONE);
            flag_UPD = true;
        }
    }
}