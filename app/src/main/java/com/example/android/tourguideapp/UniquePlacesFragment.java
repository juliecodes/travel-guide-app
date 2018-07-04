package com.example.android.tourguideapp;

/**
 * CREDITS:
 *
 * CHERRY BLOSSOM, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/toptechwriter/13772117114/
 *
 * EINSTEIN, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/afagen/475575024/
 *
 * MERIDIAN HILL PARK, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/thisisbossi/7877797614/
 *
 * NATIONAL ARBORETUM, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/davidlind/11408488963/
 *
 * CATHEDRAL, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/markalanandre/32555153602/
 *
 * WATERMELON, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/voteprime/3396973026/
 *
 * WHARF DC, cropped to square
 * CC BY 2.0
 * https://www.flickr.com/photos/krossbow/5363625295/
 *
 * YARDS, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/afagen/8001749165/
 *
 * License links:
 *
 * CC BY-NC-SA 2.0
 * https://creativecommons.org/licenses/by-nc-sa/2.0/
 *
 * CC BY 2.0
 * https://creativecommons.org/licenses/by/2.0/
 *
 *
 * All other photos taken by me, J. Antipolo.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of sites.
 */
public class UniquePlacesFragment extends Fragment {


    public UniquePlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.cherry_blossom), getString(R.string.cherry_blossom_loc), R.drawable.tidalbasin1, "https://www.nps.gov/articles/dctidalbasin.htm", getString(R.string.cherry_blossom_info)));
        sites.add(new Site(getString(R.string.einstein), getString(R.string.einstein_loc), R.drawable.einstein1, "https://goo.gl/maps/gCspKSUMYTx", getString(R.string.einstein_info)));
        sites.add(new Site(getString(R.string.lantern), getString(R.string.lantern_loc), R.drawable.japaneselantern1, "https://goo.gl/maps/uM9SfAaUUQ62", getString(R.string.lantern_info)));
        sites.add(new Site(getString(R.string.meridian), getString(R.string.meridian_loc), R.drawable.meridian1, "https://www.nps.gov/places/meridian-hill-park.htm", getString(R.string.meridian_info)));
        sites.add(new Site(getString(R.string.arboretum), getString(R.string.arboretum_loc), R.drawable.arboretum1, "https://usna.usda.gov/", getString(R.string.arboretum_info)));
        sites.add(new Site(getString(R.string.roosevelt_island), getString(R.string.roosevelt_island_loc), R.drawable.tr_island1, "https://www.nps.gov/this/index.htm", getString(R.string.roosevelt_island_info)));
        sites.add(new Site(getString(R.string.cathedral), getString(R.string.cathedral_loc), R.drawable.cathedral3, "https://cathedral.org/", getString(R.string.cathedral_info)));
        sites.add(new Site(getString(R.string.watermelon), getString(R.string.watermelon_loc), R.drawable.watermelon1, "https://goo.gl/maps/zWVkXGbhnVu", getString(R.string.watermelon_info)));
        sites.add(new Site(getString(R.string.wharf), getString(R.string.wharf_loc), R.drawable.wharfdc2, "https://www.wharfdc.com/", getString(R.string.wharf_info)));
        sites.add(new Site(getString(R.string.yards_park), getString(R.string.yards_park_loc), R.drawable.yardspark1, "https://www.theyardsdc.com/", getString(R.string.yards_park_info)));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_unique);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // site_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SiteAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Site} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open the site details page when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Site} object at the given position the user clicked on
                Site currentSite = sites.get(position);

                // Create a new intent to open the {@link SiteDetailsPage}
                // Need to pass in the values to the activity and start it

                Intent siteDetailIntent = new Intent(getActivity(), SiteDetailsPage.class);

                siteDetailIntent.putExtra("mySiteTitle", currentSite.getSiteTitle());
                siteDetailIntent.putExtra("mySiteLocation", currentSite.getLocation());
                siteDetailIntent.putExtra("mySitePhoto", currentSite.getImageResourceId());
                siteDetailIntent.putExtra("mySiteUrl", currentSite.getUrl());
                siteDetailIntent.putExtra("mySiteMoreInfo", currentSite.getMoreInfo());

                startActivity(siteDetailIntent);

            }
        });


        return rootView;
    }


}