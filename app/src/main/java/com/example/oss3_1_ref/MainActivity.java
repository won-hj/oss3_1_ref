package com.example.oss3_1_ref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.oss3_1_ref.postdata;
import com.example.oss3_1_ref.ble;
public class MainActivity extends AppCompatActivity {
    //private BluetoothAdapter.LeScanCallback scanCallback;
    //BluetoothAdapter blead= BluetoothAdapter.getDefaultAdapter();
    private String user = "5jo, Ye Eun Sung, Yoon Jung Seop, Kang Byung Gyu, Yang Hae Mi, Won Hyuk Joo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Button bt_add = findViewById(R.id.bt_add);
        Button bt_delete = findViewById(R.id.bt_delete);
        Button bt_communication = findViewById(R.id.bt_communication);
        Button bt_showdata = findViewById(R.id.bt_datashow);
        EditText ed_text = findViewById(R.id.ed_text);
        TextView tv = findViewById(R.id.tv);


        postdata myData = new postdata();
        ble ble = new ble();

        //블루투스가 실행되지 않았으면 실행
        ble.ble();

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //블루투스 스캔
                ble.starScan();
                String key = ble.getKey();
                if(key != null){
                    myData.set_data(user, key);
                }
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스캔 중지
                ble.stopScan();
            }
        });
        bt_communication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myData.data_send();
            }
        });
        bt_showdata.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                myData.data_show();
                tv.setText(user + ble.getKey());
            }
        });
    }
}