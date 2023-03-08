package com.example.fragments_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentInfoContacto extends Fragment {

    /*Método dónde se crea el Fragment y se asigna el layout a este. En este Fragment se definen
    los elementos necesarios para mostrar la información del contacto seleccionado.*/
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragmento_info_contactos, container, false);
    }

    //Método que mostrará los datos del contacto seleccionado.
    public void mostrarDetalle(String texto) {
        TextView txtInformacion =
                (TextView)getView().findViewById(R.id.informacionTV);

        txtInformacion.setText(texto);
    }
}
