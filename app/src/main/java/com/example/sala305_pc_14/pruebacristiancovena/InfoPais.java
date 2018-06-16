package com.example.sala305_pc_14.pruebacristiancovena;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InfoPais
{
    private String Name;
    private String Capital;
    private String flag;

    public InfoPais(JSONObject jsonObject) throws JSONException {
        this.Name = jsonObject.getString("Name");
        this.Capital =jsonObject.getString("Capital");
    }
public InfoPais(){

}


    public static ArrayList<InfoPais> JsonObjectsBuil(JSONArray datos) throws JSONException {

        ArrayList<InfoPais> infoPais = new ArrayList<>();
        for(int i = 0;i< datos.length(); i++){
            infoPais.add(new InfoPais(datos.getJSONObject(i)));
        }
        return infoPais;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
