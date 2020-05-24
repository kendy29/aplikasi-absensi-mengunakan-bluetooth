package com.ptcintadamai.discovering;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText eTanggal, eMata;
    Button btnScan, btnSave, btnHadir;
    ListView listView;
    ArrayList<String> stringArrayList=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    BluetoothAdapter bluetoothAdapter;
    public static DatabaseHelper data1;
    private String daftar="";
    private String daftar1="";
    private String s;
    private boolean i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTanggal=findViewById(R.id.edtTanggal);
        eMata=findViewById(R.id.edtMata);
        btnHadir=findViewById(R.id.btnHadir);
        data1=new DatabaseHelper(this);
        btnScan=findViewById(R.id.btnScan);
        btnSave=findViewById(R.id.btnSave);
        listView=findViewById(R.id.listView);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.startDiscovery();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = data1.insertData(daftar, eTanggal.getText().toString(), eMata.getText().toString());
                if (i == false) {
                    Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "berhasil", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnHadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ActivityMahasiswa.class);
                startActivity(i);
            }
        });
        IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myReciver,intentFilter);
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringArrayList);
        listView.setAdapter(adapter);
    }
    BroadcastReceiver myReciver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                daftar1=device.getName();
                if (!stringArrayList.contains(device.getName())) {
                    stringArrayList.add(device.getName());
                    daftar+=device.getName()+"\n";
                }
                adapter.notifyDataSetChanged();
            }
        }
    };
}
