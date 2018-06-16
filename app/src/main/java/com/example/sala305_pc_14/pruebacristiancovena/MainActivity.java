package com.example.sala305_pc_14.pruebacristiancovena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import webservice.Asynchtask;
import webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {


    ListView lvpaises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvpaises = (ListView)this.findViewById(R.id.lvpaises);

        lvpaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pais  p = (Pais)lvpaises.getAdapter().getItem(position);
                Intent i = new Intent(MainActivity.this,ActivityDetailCountry.class);
                i.putExtra("code",p.getAlpha2_code());
                MainActivity.this.startActivity(i);
            }
        });
        String url = "http://services.groupkt.com/country/get/all";
        Map<String,String> datos = new HashMap<>();
        WebService ws = new WebService(url,datos,this,this);
        ws.execute("");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        try{
            Log.d("Result" , result);
            JSONObject json = new JSONObject(result);
            JSONObject jsonresresponse = json.getJSONObject("RestResponse");
            JSONArray jsonArray = jsonresresponse.getJSONArray("result");
            Pais p = new Pais();
            ArrayList<Pais> pais = Pais.JsonObjectsBuil(jsonArray);
            AdapterPais ad = new AdapterPais(MainActivity.this,pais);
            lvpaises.setAdapter(ad);
        }
        catch (JSONException ex){
            Log.e("ERROR " ,  result +  ex.getMessage());
            ex.printStackTrace();
        }
    }
}
