package com.offspring.tftcontrolpanel.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.offspring.tftcontrolpanel.R;

import java.util.ArrayList;

/**
 * Created by laptop88 on 11/13/2016.
 */

public class DeviceAdapter extends ArrayAdapter<BluetoothDevice> {
    public DeviceAdapter(Context context, ArrayList<BluetoothDevice> bluetoothDevices) {
        super(context, 0, bluetoothDevices);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BluetoothDevice bluetoothDevice = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_device_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvMacAddress = (TextView) convertView.findViewById(R.id.tvMacAddress);
        tvName.setText(bluetoothDevice.getName());
        tvMacAddress.setText(bluetoothDevice.getAddress());
        // Return the completed view to render on screen
        return convertView;
    }
}
