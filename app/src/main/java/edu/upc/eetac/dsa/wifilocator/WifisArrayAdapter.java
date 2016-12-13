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
    private LayoutInflater inflater;

    private static class ViewHolder {
        private TextView BSSID;
        private TextView SSID;
        private TextView level;

        ViewHolder(){}
    }

    public WifisArrayAdapter(Context context, List<WifiNetwork> objects) {
        super(context, R.layout.activity_main, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
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

        return itemView;
    }
}
