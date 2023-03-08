package com.example.fragments_v2;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements FragmentLista.ContactoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se declara y enlaza la clase FragmentLista con el componente definido a nivel de layout
        FragmentLista frgListado =(FragmentLista)getSupportFragmentManager().findFragmentById(R.id.fragmentListaContactos);

        //Se realiza la llamada al método setContactoListener() indicándolo como parámetro el contexto
        frgListado.setContactoListener(this);
    }

    //Método que se ejecutará cuando se seleccione un contacto de la lista.
    @Override
    public void onContactoSeleccionado(Contacto c) {
        boolean detalle = (getSupportFragmentManager().findFragmentById(R.id.fragmentInformacion) != null);

        if(detalle) {
            ((FragmentInfoContacto)getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentInformacion))
                    .mostrarDetalle("Nombre: " + c.getNombre() + "\nApellidos: " + c.getApellidos()
                            + "\nTeléfono: " + c.getTelefono() + "\nDirección: " + c.getDireccion());
        }
    }
}
