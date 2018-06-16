package com.example.sala305_pc_14.pruebacristiancovena;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import webservice.Asynchtask;
import webservice.WebService;

public class ActivityDetailCountry extends AppCompatActivity implements Asynchtask {

    TextView tvnombre;
    TextView tvcapital;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailcountry);
        tvcapital = (TextView)findViewById(R.id.tvcapital);
        tvnombre = (TextView)findViewById(R.id.tvnombre);
        Intent intent = getIntent();
        String resultado = intent.getStringExtra("code");
        String url = "http://www.geognos.com/api/en/countries/info/" + resultado+".json";
        Map<String,String> datos = new HashMap<>();
        WebService ws = new WebService(url,datos,this,this);
        ws.execute("");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        Log.d("Main","Resultado " +result);
        JSONObject json = new JSONObject(result);
        JSONObject jsonreslt = json.getJSONObject("Results");
        String name = jsonreslt.getString("Name");
        JSONObject capital = jsonreslt.getJSONObject("Capital");
        String capitalname = capital.getString("Name");
        tvnombre.setText(name);
        tvcapital.setText(capitalname);
    }
}
