package com.example.bluetoothimagebuttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    BluetoothAdapter bluetoothAdapter;
    private boolean bluetoothState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothState) {
                    bluetoothAdapter.enable();
                    bluetoothState = true;
                    imageButton.setImageResource(R.drawable.on);
                } else {
                    bluetoothAdapter.disable();
                    bluetoothState = false;
                    imageButton.setImageResource(R.drawable.off);
                }
            }
        });
    }
}