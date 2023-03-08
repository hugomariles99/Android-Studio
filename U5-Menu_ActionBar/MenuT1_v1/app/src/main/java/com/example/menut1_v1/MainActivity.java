package com.example.menut1_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info =(TextView)findViewById(R.id.info);
    }

    //Creamos el Menu (inflate)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.insert:
                //metodoAdd()
                info.setText("Se presionó Insertar");
                return true;
            case R.id.edit:
                //metodoSearch()
                info.setText("Se presionó Editar");
                return true;
            case R.id.delete:
                //metodoDelete()
                info.setText("Se presionó Eliminar");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}