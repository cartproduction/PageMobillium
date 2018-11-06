package com.page.mobilium;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends ArrayAdapter<DataList>{

    private List<DataList> dataObjectList = new ArrayList<DataList>();
    private final Context context;

    public CategoryAdapter(Context context, List<DataList> myDataset) {
        super(context, R.layout.item_category, myDataset);

        this.context = context;
        this.dataObjectList = myDataset;

    }


    @Override
    public int getCount() {
        return dataObjectList.size();
    }

    @Override
    public DataList getItem(int position) {
        return dataObjectList.get(position);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if(convertView == null){
            LayoutInflater lInflater = (LayoutInflater)context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            convertView = lInflater.inflate(R.layout.item_category, null);
        }

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll);

        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) ll.getLayoutParams();
        lp.height = height/2;
        ll.setLayoutParams(lp);

        TextView titleTextView = (TextView) convertView.findViewById(R.id.firstLine);
        TextView count = (TextView) convertView.findViewById(R.id.secondLine);
        ImageView titleImageView = (ImageView) convertView.findViewById(R.id.icon);

        ViewGroup.LayoutParams lp2 = (ViewGroup.LayoutParams) titleImageView.getLayoutParams();
        lp2.height = height/3;
        titleImageView.setLayoutParams(lp2);

        Picasso.with(context).load(dataObjectList.get(i).getImage()).into(titleImageView);

        titleTextView.setText(dataObjectList.get(i).getTitle());
        count.setText(dataObjectList.get(i).getDes());

        return convertView;
    }


}