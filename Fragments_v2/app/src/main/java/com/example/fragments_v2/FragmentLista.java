package com.example.fragments_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

//Clase que heredará de Fragment para implementar los métodos onCreateView() y onActivityCreated().
public class FragmentLista extends Fragment {

    /*Se crea un Array de Objetos Contacto con los campos nombre, apellidos, teléfono y dirección
    inicializados*/
    public Contacto[] contacto = new Contacto []
            {
                    new Contacto("Juan","Perez","6561234567","Calle Guadalupe 56"),
                    new Contacto("Jose","Dominguez","6567654321","Calle Lapiz 123"),
                    new Contacto("Diana","Mariscal","0123456789","Calle Hernandez 567"),
                    new Contacto("Hugo","Mariles","9876543210","Calle San Vicente 123"),
            };
    private ListView listaContactosLV;
    private ContactoListener contactoListener;

    /*Método dónde se crea el Fragment y se asigna el layout a este. En este Fragment se define
    un control de selección ListView para mostrar la lista de contactos.*/
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lista_contactos, container, false);
    }

    /*Método que se ejecutará cuando la Activity del Fragment esté completamente
     creada.*/
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        //Asignamos al componente ListView el recurso definido a nivel de Layout.
        listaContactosLV = (ListView)getView().findViewById(R.id.listContactos);

        //Cargamos el adaptador en el componente ListView.
        listaContactosLV.setAdapter(new AdapterListaContactos(this));

        //Evento encargado de controlar que elemento de la lista ha sido seleccionado.
        listaContactosLV.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (contactoListener!=null) {
                    contactoListener.onContactoSeleccionado(
                            (Contacto)listaContactosLV.getAdapter().getItem(pos));
                    Contacto contacto = (Contacto)list.getItemAtPosition(pos);
                    Toast.makeText(getActivity(), "Contacto Seleccionado: " + contacto.getNombre()
                            , Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Se define una interfaz con un método que se ejecutará desde el evento onItemClick()
    public interface ContactoListener
    {
        void onContactoSeleccionado(Contacto c);
    }

    public void setContactoListener(ContactoListener contactoListener)
    {
        this.contactoListener = contactoListener;
    }

    /*Se crea el adaptador que extiende de la Clase ArrayAdapter, para construir la vista de cada item
    del componente ListView, con los recursos ya definidos en el layout.*/
    class AdapterListaContactos extends ArrayAdapter<Contacto> {

        Activity context;

        AdapterListaContactos(Fragment context) {
            super(context.getActivity(), R.layout.list_item_contactos, contacto);
            this.context = context.getActivity();
        }

        /*Método que se encargará de construir un nuevo objeto View con el layout creado
        a partir de esta nueva Activity, mostrando en cada una de las líneas del ListView
        esta nueva vista.*/
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_contactos, null);

            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(contacto[position].getNombre());

            TextView tvTelefono = (TextView)item.findViewById(R.id.tvTelefono);
            tvTelefono.setText(contacto[position].getTelefono());

            return(item);
        }
    }
}
