package com.example.sala305_pc_14.pruebacristiancovena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterPais extends BaseAdapter{
    private ArrayList<Pais> list;
    Context context;
    public AdapterPais(Context context, ArrayList<Pais> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Pais getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.rowpais, null);
        TextView tvpais = (TextView)item.findViewById(R.id.tvnombre);
        ImageView imgflag = (ImageView)item.findViewById(R.id.imageView);
        tvpais.setText(list.get(position).getName());
        Glide.with(context).load("http://www.geognos.com/api/en/countries/flag/" + list.get(position).getAlpha2_code() +".png").into(imgflag);
        return item;
    }
}
