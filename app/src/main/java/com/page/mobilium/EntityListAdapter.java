package com.page.mobilium;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EntityListAdapter extends ArrayAdapter<DataList>{

    private List<DataList> mList = new ArrayList<DataList>();
    private final Context context;

    public EntityListAdapter(Context context, List<DataList> myDataset) {
        super(context, R.layout.entity_item_layout, myDataset);
        this.context = context;
        this.mList = myDataset;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public DataList getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if(convertView == null){
            LayoutInflater lInflater = (LayoutInflater)context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            convertView = lInflater.inflate(R.layout.entity_item_layout, null);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.firstLine);
        ImageView titleImageView = (ImageView) convertView.findViewById(R.id.icon);

        titleTextView.setText(mList.get(i).title);

        Picasso.with(context).load(mList.get(i).image).into(titleImageView);

        return convertView;
    }


}