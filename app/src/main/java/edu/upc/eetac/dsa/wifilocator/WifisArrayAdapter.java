package edu.upc.eetac.dsa.wifilocator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ericmassip on 13/12/16.
 */

public class WifisArrayAdapter extends ArrayAdapter<WifiNetwork> {
    private final Context context;

    public WifisArrayAdapter(Context context, List<WifiNetwork> objects) {
        super(context, R.layout.activity_main, objects);
        this.context = context;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.wifis_array_adapter, parent, false);
        TextView BSSID = (TextView) rowView.findViewById(R.id.bssid);
        TextView SSID = (TextView) rowView.findViewById(R.id.ssid);
        TextView level = (TextView) rowView.findViewById(R.id.level);
        WifiNetwork wifiNetwork = getItem(position);
        BSSID.setText(wifiNetwork.BSSID);
        SSID.setText(wifiNetwork.SSID);
        level.setText(Double.toString(wifiNetwork.level));

        return rowView;

        /*View itemView = convertView;
        ViewHolder holder = null;
        final WifiNetwork wifiNetwork = getItem(position);

        if(null == itemView) {
            itemView = this.inflater.inflate(R.layout.activity_main, parent, false);

            holder = new ViewHolder();

            holder.BSSID = (TextView) itemView.findViewById(R.id.bssid);
            holder.SSID = (TextView) itemView.findViewById(R.id.ssid);
            holder.level = (TextView) itemView.findViewById(R.id.level);

            itemView.setTag(holder);
        } else {
            holder = (ViewHolder)itemView.getTag();
        }

        if (wifiNetwork != null) {
            holder.BSSID.setText(wifiNetwork.BSSID);
            holder.SSID.setText(wifiNetwork.SSID);
            holder.level.setText(Double.toString(wifiNetwork.level));
        }

        return itemView;*/
    }
}
