package com.example.oss3_1_ref;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.lang.reflect.Array;

public class ble {
    public void ble(){
        //블루투스 실행
        if (!blead.isEnabled()) blead.enable();

    }

    //블루투스어댑터 콜백함수 선언
    private BluetoothAdapter.LeScanCallback scanCallback;
    //기본어댑터 선언
    BluetoothAdapter blead = BluetoothAdapter.getDefaultAdapter();

    String key = null;
    protected String getKey(){
        return key;
    }


    protected void starScan() {
        blead.startLeScan(scanCallback_le); //scanCallback_le 직접 함수 만들기
    }
    protected void stopScan(){
        blead.stopLeScan(scanCallback_le);
    }

    private BluetoothAdapter.LeScanCallback scanCallback_le = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
            String macAdd = bluetoothDevice.getAddress();
            String data =byteArrayToHex(bytes);

            if(macAdd.equals("B8:27:EB:7F:E7:58")){
                String pattern = "998899";
                key = byteArrayToHex(bytes);
                //int index =key.indexOf(pattern);

                String temp = key.split(pattern)[1];
                Log.e("keySplit(998899)", temp);

            }
        }
    };
    protected String byteArrayToHex(byte[] byteArray) {
        StringBuilder hex = new StringBuilder(); //여러 문자열을 조합하여 하나의 문자열로 만드는데 사용(StringBuilder)
        for (byte b : byteArray) {
            hex.append(String.format("%02x", b&0xff)); //수정
        }
        return hex.toString();
    }
}
