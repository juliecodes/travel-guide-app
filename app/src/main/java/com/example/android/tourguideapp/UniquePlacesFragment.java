package com.example.android.tourguideapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class UniquePlacesFragment extends Fragment {




    public UniquePlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site("National Arboretum", "3501 New York Ave NE", R.drawable.color_red, "https://usna.usda.gov/", "Gorgeous outdoor place with giant columns and bonsai garden."));
        sites.add(new Site("Meridian Hill Park", "16th St NW & W Street NW", R.drawable.color_red, "https://www.nps.gov/places/meridian-hill-park.htm", "Beautiful park featuring large water structure."));
        sites.add(new Site("Theodore Roosevelt Island", "Theodore Roosevelt Island", R.drawable.color_red, "https://www.nps.gov/this/index.htm","Island south of the DC mainland."));
        sites.add(new Site("The Einstein Memorial", "2101 Constitution Ave NW", R.drawable.color_red, "http://www.nasonline.org/about-nas/visiting-nas/nas-building/the-einstein-memorial.html", "Giant Einstein sculpture."));
        sites.add(new Site("Washington National Cathedral", "3101 Wisconsin Ave. NW", R.drawable.color_red, "https://cathedral.org/","Beautiful cathedral."));
        sites.add(new Site("The Wharf DC", "1100 Maine Ave SW", R.drawable.color_red, "https://www.wharfdc.com/","Cute area featuring old fisherman market as well as swings and a firepit. Shopping, dining, and entertainment, too."));
        sites.add(new Site("Japanese Lantern", "9810 Kutz Bridge", R.drawable.color_red, "https://en.wikipedia.org/wiki/Japanese_Lantern_(Washington,_D.C.)","This Japanese lantern was a gift from Japan and is lit during the annual Cherry Blossom Festival."));
        sites.add(new Site("Tidal Basin (Cherry Blossom Season)", "Tidal Basin", R.drawable.color_red, "https://www.nps.gov/articles/dctidalbasin.htm","Come to the Tidal Basin during the Cherry Blossom Festival."));
        sites.add(new Site("Blind Whino", "700 Delaware Ave SW", R.drawable.color_red, "https://www.blindwhino.org/","Former church turned art gallery space. It is painted from floor to ceiling with murals, inside and out."));
        sites.add(new Site("Yards Park", "355 Water St SE", R.drawable.color_red, "https://www.theyardsdc.com/",""));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_unique);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SiteAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Site} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                // Get the {@link Site} object at the given position the user clicked on
                Site currentSite = sites.get(position);


                /** New section added July 1 START */

                //public void onClick (View view) {
                // Create a new intent to open the {@link SongDetailsPage}
                // Need to pass in the values to the activity and start it
                // the activity and start it

                //Context onClickContext = getContext();
                Intent siteDetailIntent = new Intent(getActivity(), SiteDetailsPage.class);


                siteDetailIntent.putExtra("mySiteTitle", currentSite.getTitle());
                siteDetailIntent.putExtra("mySiteLocation", currentSite.getLocation());
                siteDetailIntent.putExtra("mySitePhoto", currentSite.getImageResourceId());
                siteDetailIntent.putExtra("mySiteUrl", currentSite.getUrl());
                siteDetailIntent.putExtra("mySiteMoreInfo", currentSite.getMoreInfo());

                startActivity(siteDetailIntent);
                //}

                /**  New section added July 1 END */

            }
        });






        return rootView;
    }



}