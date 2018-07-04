/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link SiteAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Site} objects.
 */
public class SiteAdapter extends ArrayAdapter<Site> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link SiteAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param sites   is the list of {@link Site}s to be displayed.
     */
    public SiteAdapter(Context context, ArrayList<Site> sites, int ColorResourceId) {
        super(context, 0, sites);
        mColorResourceId = ColorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Site} object located at this position in the list
        Site currentSite = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID site_title_text_view.
        TextView siteTitleTextView = (TextView) listItemView.findViewById(R.id.site_title_text_view);
        // Get the Site Title from the currentSite object and set this text on
        // the Site Title TextView.
        siteTitleTextView.setText(currentSite.getSiteTitle());

        // Find the TextView in the list_item.xml layout with the ID site_loc_text_view.
        TextView siteLocTextView = (TextView) listItemView.findViewById(R.id.site_loc_text_view);
        // Get the site location from the currentSite object and set this text on
        // the Site Location TextView.
        siteLocTextView.setText(currentSite.getLocation());


        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);


        if (currentSite.hasImage()) {
            // Get the image resource ID from the currentSite object and set this image on
            // the default ImageView.

            imageView.setImageResource(currentSite.getImageResourceId());
            // make image visible
            imageView.setVisibility(View.VISIBLE);


        } else {
            // make image not visible and remove it entirely so it doesn't take up space in the layout
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}