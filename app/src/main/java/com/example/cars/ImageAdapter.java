package com.example.cars;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mThumbIds;
    private List<Integer> carNames;
    private List<Integer> webpages;
    private LayoutInflater layoutInflater;

    public ImageAdapter(Context c, List<Integer> ids, List<Integer> car_name, List<Integer> car_webpage) {
        this.mContext = c;
        this.mThumbIds = ids;
        this.carNames = car_name;
        this.webpages = car_webpage;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    public Object getWebPage(int position) {
        return webpages.get(position);
    }

    // Return the number of items in the adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.thumbnail_identifier, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.carName);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        textView.setText(carNames.get(position));
        imageView.setImageResource(mThumbIds.get(position));

        return convertView;
    }


}
