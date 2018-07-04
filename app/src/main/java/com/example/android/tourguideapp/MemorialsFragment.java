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
        sites.add(new Site(getString(R.string.fdr), getString(R.string.fdr_loc), R.drawable.fdr1, "https://www.nps.gov/frde/index.htm", getString(R.string.fdr_info)));
        sites.add(new Site(getString(R.string.korean), getString(R.string.korean_loc), R.drawable.koreanwar3, "https://www.nps.gov/kowa/index.htm", getString(R.string.korean_info)));
        sites.add(new Site(getString(R.string.lincoln), getString(R.string.lincoln_loc), R.drawable.lincoln1, "https://www.nps.gov/linc/index.htm", getString(R.string.lincoln_info)));
        sites.add(new Site(getString(R.string.library), getString(R.string.library_loc), R.drawable.librarycongress1, "https://www.loc.gov/", getString(R.string.library_info)));
        sites.add(new Site(getString(R.string.mlk), getString(R.string.mlk_loc), R.drawable.mlk1, "https://www.nps.gov/mlkm/planyourvisit/basicinfo.htm", getString(R.string.mlk_info)));
        sites.add(new Site(getString(R.string.wwii), getString(R.string.wwii_loc), R.drawable.wwiimemorial4, "https://www.nps.gov/wwii/index.htm", getString(R.string.wwii_info)));
        sites.add(new Site(getString(R.string.jefferson), getString(R.string.jefferson_loc), R.drawable.jeffersonmemorial1, "https://www.nps.gov/thje/index.htm", getString(R.string.jefferson_info)));
        sites.add(new Site(getString(R.string.washington_monument), getString(R.string.washington_monument_loc), R.drawable.washingtonmonument2, "https://www.nps.gov/wamo/index.htm", getString(R.string.washington_monument_info)));


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