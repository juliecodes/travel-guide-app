package com.example.android.tourguideapp;

/**
 * CREDITS:
 *
 * FRANKLIN D ROOSEVELT MEMORIAL
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/shifted/10063360804/
 *
 * WORLD WAR II MEMORIAL
 * CC BY-NC 2.0
 * https://www.flickr.com/photos/pianowow/9137864537/
 *
 * Licenses:
 *
 * CC BY-NC-SA 2.0
 * https://creativecommons.org/licenses/by-nc-sa/2.0/
 *
 * CC BY 2.0
 * https://creativecommons.org/licenses/by-nc/2.0/
 *
 *
 * All other photos taken by me, J. Antipolo.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of sites.
 */
public class MemorialsFragment extends Fragment {

    public MemorialsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site("Franklin D. Roosevelt Memorial", "1850 West Basin Dr SW", R.drawable.fdr1, "https://www.nps.gov/frde/index.htm", "This memorial features waterfalls."));
        sites.add(new Site("Korean War Veterans Memorial", "900 Ohio Dr SW", R.drawable.koreanwar3, "https://www.nps.gov/kowa/index.htm", "I stumbled upon this by accident one day. Really moving memorial."));
        sites.add(new Site("Lincoln Memorial", "2 Lincoln Memorial Cir NW", R.drawable.lincoln1, "https://www.nps.gov/linc/index.htm", "The most iconic memorial in Washington, next to the Washington Monument."));
        sites.add(new Site("Library of Congress", "101 Independence Ave SE", R.drawable.librarycongress1, "https://www.loc.gov/", "Not a tradtional memorial, but it is a beautiful historic building."));
        sites.add(new Site("Martin Luther King Memorial", "1964 Independence Ave SW", R.drawable.mlk1, "https://www.nps.gov/mlkm/planyourvisit/basicinfo.htm", "Inspiring memorial in the tidal basin."));
        sites.add(new Site("National World War II Memorial", "1750 Independence Ave SW", R.drawable.wwiimemorial4, "https://www.nps.gov/wwii/index.htm", "This memorial features a fountain that lights up at night."));
        sites.add(new Site("Thomas Jefferson Memorial", "701 E Basin Dr SW", R.drawable.jeffersonmemorial1, "https://www.nps.gov/thje/index.htm", "Grand memorial best visited during cherry blossom season"));
        sites.add(new Site("Washington Monument", "2 15th St NW", R.drawable.washingtonmonument2, "https://www.nps.gov/wamo/index.htm", "The most iconic memorial in Washington, next to the Lincoln Memorial."));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_memorials);

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