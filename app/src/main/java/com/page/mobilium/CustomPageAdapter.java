
package com.page.mobilium;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPageAdapter extends PagerAdapter {
    private Context context;
    private List<DataList> dataObjectList;
    private LayoutInflater layoutInflater;
    public CustomPageAdapter(Context context, List<DataList> dataObjectList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }
    @Override
    public int getCount() {
        return dataObjectList.size();
    }
    @Override
    public float getPageWidth(int position) {
        return(0.3f);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.item_category, container, false);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll);

        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) ll.getLayoutParams();
        lp.height = height/2;
        ll.setLayoutParams(lp);

        TextView titleTextView = (TextView) view.findViewById(R.id.firstLine);
        TextView count = (TextView) view.findViewById(R.id.secondLine);
        ImageView titleImageView = (ImageView) view.findViewById(R.id.icon);

        ViewGroup.LayoutParams lp2 = (ViewGroup.LayoutParams) titleImageView.getLayoutParams();
        lp2.height = height/3;
        titleImageView.setLayoutParams(lp2);

        Picasso.with(context).load(dataObjectList.get(position).getImage()).into(titleImageView);

        titleTextView.setText(dataObjectList.get(position).getTitle());
        count.setText(dataObjectList.get(position).getDes());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}