package com.example.proyectofinal_appmoviles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "ProyectoFinal_AppMoviles_DB.sqlite";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Productos";
    private static final String ID_COL = "id_producto";
    private static final String NOMBRE_COL = "nombre_producto";
    private static final String PRECIO_COL = "precio_producto";
    private static final String CATEGORIA_COL = "categoria_producto";
    private static final String STOCK_COL = "stock_producto";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    public void createProductos() {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, "
                + NOMBRE_COL + " TEXT,"
                + PRECIO_COL + " TEXT,"
                + CATEGORIA_COL + " TEXT,"
                + STOCK_COL + " TEXT)";
        db.execSQL(query);
    }

    public void insertProducto(String idProducto, String nombreProducto, String precioProducto,
                               String categoriaProducto, String stockProducto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ID_COL, idProducto);
        values.put(NOMBRE_COL, nombreProducto);
        values.put(PRECIO_COL, precioProducto);
        values.put(CATEGORIA_COL, categoriaProducto);
        values.put(STOCK_COL, stockProducto);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean deleteProducto(String nombreProducto) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, NOMBRE_COL + "=?", new String[]{nombreProducto}) > 0;
    }

    public String selectProducto() {
        SQLiteDatabase db = this.getReadableDatabase();

        String data = "";

        Cursor c = db.rawQuery("SELECT nombre_producto, precio_producto FROM 'Productos'", null);
        boolean first = true;
        if (c.moveToFirst()) {
            do {
                if (first) {
                    String nombre = c.getString(0);
                    data += nombre;
                    String precio = c.getString(1);
                    data += "-" + precio;
                    first = false;
                } else {
                    String nombre = c.getString(0);
                    data += "@" + nombre;
                    String precio = c.getString(1);
                    data += "-" + precio;
                }
            } while (c.moveToNext());
        }
        c.close();
        db.close();

        return data;
    }

    public void updateProducto(String idProducto, String nombreProducto, String precioProducto,
                               String categoriaProducto, String stockProducto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ID_COL, idProducto);
        values.put(NOMBRE_COL, nombreProducto);
        values.put(PRECIO_COL, precioProducto);
        values.put(CATEGORIA_COL, categoriaProducto);
        values.put(STOCK_COL, stockProducto);

        db.update(TABLE_NAME, values, ID_COL + "=?", new String[]{idProducto});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void fillDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ID_COL, "1");
        values.put(NOMBRE_COL, "Limpiador Multiusos");
        values.put(PRECIO_COL, "80");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "2");
        values.put(NOMBRE_COL, "Limpiador de Vidrio");
        values.put(PRECIO_COL, "100");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "3");
        values.put(NOMBRE_COL, "Limpiador de Cocina");
        values.put(PRECIO_COL, "70");
        values.put(CATEGORIA_COL, "Cocina");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "4");
        values.put(NOMBRE_COL, "Limpiador de Bano");
        values.put(PRECIO_COL, "120");
        values.put(CATEGORIA_COL, "Bano");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "5");
        values.put(NOMBRE_COL, "Trapeador Pesado");
        values.put(PRECIO_COL, "475");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "6");
        values.put(NOMBRE_COL, "Trapeador");
        values.put(PRECIO_COL, "90");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "7");
        values.put(NOMBRE_COL, "Escoba");
        values.put(PRECIO_COL, "100");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "8");
        values.put(NOMBRE_COL, "Recogedor");
        values.put(PRECIO_COL, "60");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "9");
        values.put(NOMBRE_COL, "Trapeador de Algodon");
        values.put(PRECIO_COL, "105");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "10");
        values.put(NOMBRE_COL, "Escoba para piso laminado");
        values.put(PRECIO_COL, "130");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        values.put(ID_COL, "11");
        values.put(NOMBRE_COL, "Exprimidor");
        values.put(PRECIO_COL, "150");
        values.put(CATEGORIA_COL, "Hogar");
        values.put(STOCK_COL, "50");
        db.insert(TABLE_NAME, null, values);

        db.close();
    }
}