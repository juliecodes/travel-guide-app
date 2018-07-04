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
        sites.add(new Site("Cherry Blossom Season", "Tidal Basin", R.drawable.tidalbasin1, "https://www.nps.gov/articles/dctidalbasin.htm", "Come to the Tidal Basin during cherry blossom season."));
        sites.add(new Site("The Einstein Memorial", "2101 Constitution Ave NW", R.drawable.einstein1, "http://www.nasonline.org/about-nas/visiting-nas/nas-building/the-einstein-memorial.html", "Giant Einstein sculpture."));
        sites.add(new Site("Japanese Lantern", "9810 Kutz Bridge", R.drawable.japaneselantern1, "https://en.wikipedia.org/wiki/Japanese_Lantern_(Washington,_D.C.)", "This Japanese lantern was a gift from Japan and is lit during the annual Cherry Blossom Festival."));
        sites.add(new Site("Meridian Hill Park", "16th St NW & W Street NW", R.drawable.meridian1, "https://www.nps.gov/places/meridian-hill-park.htm", "Beautiful park featuring large water structure."));
        sites.add(new Site("National Arboretum", "3501 New York Ave NE", R.drawable.arboretum1, "https://usna.usda.gov/", "Gorgeous outdoor place with giant columns and bonsai garden."));
        sites.add(new Site("Theodore Roosevelt Island", "Theodore Roosevelt Island", R.drawable.tr_island1, "https://www.nps.gov/this/index.htm", "Island south of the DC mainland."));
        sites.add(new Site("Washington National Cathedral", "3101 Wisconsin Ave NW", R.drawable.cathedral3, "https://cathedral.org/", "Beautiful cathedral."));
        sites.add(new Site("Watermelon House", "1112 Q St NW", R.drawable.watermelon1, "https://goo.gl/maps/zWVkXGbhnVu", "Artist: Wade Wilson and Robert Banaszak"));
        sites.add(new Site("The Wharf DC", "1100 Maine Ave SW", R.drawable.wharfdc2, "https://www.wharfdc.com/", "Cute area featuring old fisherman market as well as swings and a firepit. Shopping, dining, and entertainment, too."));
        sites.add(new Site("Yards Park", "355 Water St SE", R.drawable.yardspark1, "https://www.theyardsdc.com/", "Nice area to splash in the water and stroll along a really cool bridge."));


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

                siteDetailIntent.putExtra("mySiteTitle", currentSite.getTitle());
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