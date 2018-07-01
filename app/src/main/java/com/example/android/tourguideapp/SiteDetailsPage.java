package com.example.android.tourguideapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.TextView;

import com.example.android.tourguideapp.R;

import java.util.ArrayList;

/**
 * Created by julietantipolo on 6/16/18.
 */

public class SiteDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_details_page);

        String mySiteTitle = getIntent().getExtras().getString("mySiteTitle");
        TextView siteDetailsTitle = (TextView) findViewById(R.id.site_detail_title_view);
        siteDetailsTitle.setText(mySiteTitle);

        String mySiteLocation = getIntent().getExtras().getString("mySiteLocation");
        TextView siteDetailsLocation = (TextView) findViewById(R.id.site_detail_location_view);
        siteDetailsLocation.setText(mySiteLocation);

        String mySiteMoreInfo = getIntent().getExtras().getString("mySiteMoreInfo");
        TextView siteDetailsMoreInfo = (TextView) findViewById(R.id.site_detail_more_info);
        siteDetailsMoreInfo.setText(mySiteMoreInfo);

        String mySiteUrl = getIntent().getExtras().getString("mySiteUrl");
        TextView siteDetailsUrl = (TextView) findViewById(R.id.site_detail_url_link);
        siteDetailsUrl.setText(mySiteUrl);
        Linkify.addLinks(siteDetailsUrl, Linkify.WEB_URLS);




    }
}


