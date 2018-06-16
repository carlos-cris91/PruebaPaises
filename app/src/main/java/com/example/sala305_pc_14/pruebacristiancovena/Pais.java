package com.example.sala305_pc_14.pruebacristiancovena;

import android.text.Html;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {
    private String name;
    private String alpha3_code;
    private String alpha2_code;

    private String flag;

    public String getFlag() {
        return flag;
    }


    public Pais(){

    }
    public Pais(JSONObject jsonObject) throws JSONException {
        this.name = jsonObject.getString("name");
        this.alpha2_code =jsonObject.getString("alpha2_code");
        this.alpha3_code =jsonObject.getString("alpha3_code");
    }

    public static ArrayList<Pais> JsonObjectsBuil(JSONArray datos) throws JSONException {

        ArrayList<Pais> pais = new ArrayList<>();
        for(int i = 0;i< datos.length(); i++){
            pais.add(new Pais(datos.getJSONObject(i)));
        }
        return pais;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }

    public void setAlpha3_code(String alpha3_code) {
        this.alpha3_code = alpha3_code;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public void setAlpha2_code(String alpha2_code) {
        this.alpha2_code = alpha2_code;
    }
}
