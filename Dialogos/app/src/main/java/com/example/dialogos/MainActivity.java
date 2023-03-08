package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button boton;
    public TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.boton);
        texto = findViewById(R.id.texto);

        boton.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int d) {
        Dialog dialog = null;
        DListener listener = new DListener();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.ic_launcher_background);
        builder = builder.setTitle("Este es un dialogo con botones");
        builder = builder.setMessage("Selecciona un boton");
        builder = builder.setPositiveButton("Afirmativo", listener);
        builder = builder.setNegativeButton("Negativo", listener);
        builder = builder.setNeutralButton("Neutral", listener);
        dialog = builder.create();
        return dialog;
    }

    public class ListaContactos{
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            rootView=inflater.inflate(R.layout.ListaContactos, container, false);
            return rootView;
        }
    }

    @Override
    public void onClick(View v) {
        showDialog(0);
    }

    public void getTexto(String st) {
        texto.setText(st);
    }
}

class DListener implements DialogInterface.OnClickListener {

    MainActivity ma;

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            ma.getTexto("Presionaste el boton positivo");
        }
        if (which == DialogInterface.BUTTON_NEGATIVE) {
            ma.getTexto("Presionaste el boton negativo");
        }
        if (which == DialogInterface.BUTTON_NEUTRAL) {
            ma.getTexto("Presionaste el boton neutral");
        }
    }
}