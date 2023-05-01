package com.example.example0428;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.OutputStream;

public class bluetoothSocket extends Activity {

    private BluetoothSocket mmSocket;
    private OutputStream mmOutputStream;

    public void sendStringOverBluetooth(String message) {
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothDevice device = bluetoothAdapter.getRemoteDevice("78:21:84:8C:A6:92"); // Replace with your device's MAC address

            SerialSocket ss = new SerialSocket(device);
            ss.run();

            byte[] messageBytes = message.getBytes();
            ss.write(messageBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}