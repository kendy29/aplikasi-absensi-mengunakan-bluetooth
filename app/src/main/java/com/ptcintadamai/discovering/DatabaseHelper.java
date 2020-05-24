package com.ptcintadamai.discovering;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase dabe;
    public DatabaseHelper(Context context) {
        super(context, "Absend.db", null, 2);
        dabe=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table DaftarHadir(nama text not null,tanggal text not null,mata text not null);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists DaftarHadir");
        onCreate(db);
    }
    public boolean insertData(String nama,String tanggal,String mata){
        dabe=this.getWritableDatabase();
        ContentValues dv = new ContentValues();
        dv.put("nama",nama);
        dv.put("tanggal",tanggal);
        dv.put("mata",mata);
        long i =dabe.insert("DaftarHadir",null,dv);
        if (i==-1)
            return false;
        else
            return true;
    }
    public Cursor getData(String sql){
        dabe=getWritableDatabase();
        return dabe.rawQuery(sql,null);
    }
    public int Kehadiran(String nama){
        dabe=getReadableDatabase();
        Cursor c = dabe.rawQuery("select * from DaftarHadir where nama = ?",new String[]{nama});
        int i = c.getCount();
        return i;
    }
}
