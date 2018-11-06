package com.page.mobilium;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

import static com.page.mobilium.Application.products;

public class MainActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textView;
    ListAdapter mListAdapter;
    EntityListAdapter enListAdapter;
    ListView mListView;
    GridView gridview;
    ViewPager pager;
    ListView enListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //CUSTOME ACTIONBAR
        // Specify that tabs should be displayed in the action bar.
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.toolbar_layout, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);

        actionBar.setCustomView(mCustomView,params);
        actionBar.setDisplayShowCustomEnabled(true);

        textViewTitle = (TextView) mCustomView.findViewById(R.id.action_bar_title);
        textViewTitle.setText("V Yaka Uzun Elbise");

        textView = (TextView) findViewById(R.id.textView4);
        textView.setText("6X13,32 TL'den başlayan taksit seçenekleri");

        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.WHITE));

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        Slider slider = findViewById(R.id.slider);

        List<Slide> slideList = new ArrayList<>();
        Slide slide1 = new Slide(0,Application.urunGorseli , getResources().getDimensionPixelSize(R.dimen.slider_image_corner));
        Slide slide2 = new Slide(1,Application.urunGorseli , getResources().getDimensionPixelSize(R.dimen.slider_image_corner));
        Slide slide3 = new Slide(2,Application.urunGorseli , getResources().getDimensionPixelSize(R.dimen.slider_image_corner));

        slideList.add(slide1);
        slideList.add(slide2);
        slideList.add(slide3);
        slider.addSlides(slideList);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.geri, null);
        drawable = DrawableCompat.wrap(drawable);
        toolbar.setNavigationIcon(drawable);


        mListView = (ListView) findViewById(R.id.listView1);
        mListAdapter = new ListAdapter(this, products);
        mListView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new CategoryAdapter(this, Application.productsGrid));

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new CustomPageAdapter(this, Application.productsGrid));

        enListView = (ListView) findViewById(R.id.listView2);
        enListAdapter = new EntityListAdapter(this, Application.entityList);
        enListView.setAdapter(enListAdapter);
        enListAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.global, menu);
        return true;
    }
}
