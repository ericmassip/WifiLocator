package edu.upc.eetac.dsa.wifilocator;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends ListActivity implements View.OnClickListener {
    WifiManager wifi;
    ListView wifiNetworks;
    Button buttonScan;
    List<ScanResult> results;
    List<WifiNetwork> wifis;

    /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScan = (Button) findViewById(R.id.showWifiNetworksButton);
        buttonScan.setOnClickListener(this);
        wifiNetworks = (ListView) findViewById(R.id.wifiNetworks);

        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (!wifi.isWifiEnabled()) {
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
            wifi.setWifiEnabled(true);
        }
    }

    public void onClick(View view) {
        wifi.startScan();
        Toast.makeText(this, "Scanning....", Toast.LENGTH_SHORT).show();
        results = wifi.getScanResults();
        wifis = new ArrayList<>();
        if (results != null) {
            for (int i = 0; i < results.size(); i++) {
                WifiNetwork wifiNetwork = new WifiNetwork();
                wifiNetwork.BSSID = results.get(i).BSSID;
                wifiNetwork.SSID = results.get(i).SSID;
                wifiNetwork.level = results.get(i).level;
                wifis.add(wifiNetwork);
            }
            setListAdapter(new WifisArrayAdapter(MainActivity.this, wifis));
        }
    }
}


