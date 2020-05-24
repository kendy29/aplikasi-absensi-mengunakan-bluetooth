package com.ptcintadamai.discovering;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {
    private Context c;
    private int layout;
    private ArrayList<data> d;
    public listAdapter(Context c, int layout, ArrayList<data> foodlist) {
        this.c = c;
        this.layout = layout;
        this.d = foodlist;
    }
    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Object getItem(int position) {
        return d.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        viewHolder holder = new viewHolder();
        View view = v;
        if (view==null){
            LayoutInflater inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);


            holder.nama=(TextView)view.findViewById(R.id.txtDaftar);
            holder.tanggal=(TextView)view.findViewById(R.id.txtTanggal);
            holder.mata=(TextView)view.findViewById(R.id.txtMata);
            view.setTag(holder);

        }else{
            holder=(viewHolder)view.getTag();
        }
        data f = d.get(position);
        holder.nama.setText(f.getNama());;
        holder.tanggal.setText(f.getTanggal());
        holder.mata.setText(f.getMata());

        return view;
    }
    private class viewHolder{
        TextView nama, tanggal, mata, semua;
    }
}
