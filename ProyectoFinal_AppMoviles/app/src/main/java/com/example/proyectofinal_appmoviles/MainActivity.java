package com.example.proyectofinal_appmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public Toolbar myToolbar;

    public Button botonBanos, botonCocina, botonHogar, botonInventario;
    public ImageButton botonInicioBanos, botonInicioCocina, botonInicioHogar;

    public boolean flag_menuTresBarras = false;

    MediaPlayer sound_menu_3_barras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Proyecto-App_Movil", "Proyecto");
        Log.w("Proyecto-App_Movil", "WARNING");

        sound_menu_3_barras = MediaPlayer.create(this, R.raw.notification);
        sound_menu_3_barras.seekTo(0);
        sound_menu_3_barras.start();

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Pagina Principal");
        setSupportActionBar(myToolbar);

        fragmento_menuTresBarras_hide();

        fragmento_menuTresBarras_activity();
        inicioBotones();
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
                Intent submitIntent = new Intent(MainActivity.this, carrito_articulos_activity.class);
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

    public void fragmento_menuTresBarras_activity() {
        botonBanos = findViewById(R.id.fragment_menuTresBarras_banos);
        botonBanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, BanosActivity.class);
                startActivity(submitIntent);
            }
        });

        botonCocina = findViewById(R.id.fragment_menuTresBarras_cocina);
        botonCocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, CocinaActivity.class);
                startActivity(submitIntent);
            }
        });

        botonHogar = findViewById(R.id.fragment_menuTresBarras_hogar);
        botonHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, HogarActivity.class);
                startActivity(submitIntent);
            }
        });

        botonInventario = findViewById(R.id.fragment_menuTresBarras_inventario);
        botonInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, InventarioActivity.class);
                startActivity(submitIntent);
            }
        });
    }

    public void inicioBotones() {
        botonInicioBanos = findViewById(R.id.inicio_boton_banos);
        botonInicioBanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, BanosActivity.class);
                startActivity(submitIntent);
            }
        });

        botonInicioCocina = findViewById(R.id.inicio_boton_cocina);
        botonInicioCocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, CocinaActivity.class);
                startActivity(submitIntent);
            }
        });
        botonInicioHogar = findViewById(R.id.inicio_boton_hogar);
        botonInicioHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent(MainActivity.this, HogarActivity.class);
                startActivity(submitIntent);
            }
        });
    }
}