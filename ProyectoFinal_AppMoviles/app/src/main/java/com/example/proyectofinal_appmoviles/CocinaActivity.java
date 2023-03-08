package com.example.proyectofinal_appmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CocinaActivity extends AppCompatActivity {

    public Toolbar myToolbar;

    public Button botonBanos, botonInicio, botonHogar, botonInventario;

    public boolean flag_menuTresBarras = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cocina");
        setSupportActionBar(myToolbar);

        fragmento_menuTresBarras_hide();

        cambioDePantalla();

        Dialogo();
    }

    @Override
    protected void onPause () {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //Search
        MenuItem myActionMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setQueryHint("Buscar...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_tresBarras:
                fragmento_menuTresBarras_show();
                return true;
            case R.id.menuItem_carrito:
                Intent submitIntent = new Intent(CocinaActivity.this, carrito_articulos_activity.class);
                startActivity(submitIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void fragmento_menuTresBarras_hide() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment frag_menuTresBarras = manager.findFragmentById(R.id.paginaPrincipal_fragment_menuTresBarras);
        manager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .hide(frag_menuTresBarras)
                .commit();
    }

    public void fragmento_menuTresBarras_show() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment frag_menuTresBarras = manager.findFragmentById(R.id.paginaPrincipal_fragment_menuTresBarras);
        if (flag_menuTresBarras) {
            manager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .hide(frag_menuTresBarras)
                    .commit();
            flag_menuTresBarras = false;
        } else {
            manager.beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .show(frag_menuTresBarras)
                    .commit();
            flag_menuTresBarras = true;
        }
    }

    public void Dialogo() {
        ImageButton producto1 = findViewById(R.id.image_product1);
        ImageButton producto2 = findViewById(R.id.image_product2);
        ImageButton producto3 = findViewById(R.id.image_product3);
        ImageButton producto4 = findViewById(R.id.image_product4);
        ImageButton producto5 = findViewById(R.id.image_product5);
        ImageButton producto6 = findViewById(R.id.image_product6);
        producto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        producto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        producto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        producto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        producto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        producto6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    void showCustomDialog() {
        final Dialog dialog = new Dialog(CocinaActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);
        Button dialogoSi = dialog.findViewById(R.id.dialogo_si);
        Button dialogoNo = dialog.findViewById(R.id.dialogo_no);


        dialogoSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialogoNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void cambioDePantalla() {
        botonBanos = findViewById(R.id.fragment_menuTresBarras_banos);
        botonBanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(CocinaActivity.this, BanosActivity.class);
                startActivity(submitIntent);
            }
        });

        botonHogar = findViewById(R.id.fragment_menuTresBarras_hogar);
        botonHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(CocinaActivity.this, HogarActivity.class);
                startActivity(submitIntent);
            }
        });

        botonInicio = findViewById(R.id.fragment_menuTresBarras_inicio);
        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(CocinaActivity.this, MainActivity.class);
                startActivity(submitIntent);
            }
        });

        botonInventario = findViewById(R.id.fragment_menuTresBarras_inventario);
        botonInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(CocinaActivity.this, InventarioActivity.class);
                startActivity(submitIntent);
            }
        });
    }
}
