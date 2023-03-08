package com.example.listviewpersonalizado;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrutasVerduras frutasVerduras_datos[]= new FrutasVerduras[]{
                new FrutasVerduras(R.mipmap.apple_fg,"Manzana"),
                new FrutasVerduras(R.mipmap.cucumber_fg,"Pepino"),
                new FrutasVerduras(R.mipmap.pear_foreground,"Pera"),
                new FrutasVerduras(R.mipmap.orange_foreground,"Naranja"),
                new FrutasVerduras(R.mipmap.melon_foreground,"Sandia"),
                new FrutasVerduras(R.mipmap.lettuce_fg,"Lechuga"),
        };

        FrutasVerdurasAdapter adapter= new FrutasVerdurasAdapter(this, R.layout.listview_item_row, frutasVerduras_datos);

        lv=(ListView)findViewById(R.id.Lv);
        View header= (View)getLayoutInflater().inflate(R.layout.list_header,null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TextView v=(TextView)arg1.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
