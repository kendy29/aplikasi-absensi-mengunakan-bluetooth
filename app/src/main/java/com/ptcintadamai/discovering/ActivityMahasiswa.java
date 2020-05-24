package com.ptcintadamai.discovering;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityMahasiswa extends AppCompatActivity {
    listAdapter adapter=null;
    ListView listDaftar;
    ArrayList<data> arayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        listDaftar=findViewById(R.id.listDaftar);
        arayList=new ArrayList<>();
        adapter=new listAdapter(ActivityMahasiswa.this,R.layout.item_data,arayList);

        listDaftar.setAdapter(adapter);

        Cursor c =MainActivity.data1.getData("select * from DaftarHadir");
        arayList.clear();

        while (c.moveToNext()){
            String daftar = c.getString(0);
            String tanggal=c.getString(1);
            String mata=c.getString(2);

            arayList.add(new data(daftar,tanggal,mata));

        }
        adapter.notifyDataSetChanged();
    }
}
