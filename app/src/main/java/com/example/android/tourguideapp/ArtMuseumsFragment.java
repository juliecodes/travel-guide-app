package com.example.android.tourguideapp;

/**
 * CREDITS:
 *
 * All photos taken by me, J. Antipolo.
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
public class ArtMuseumsFragment extends Fragment {


    public ArtMuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.artechouse), getString(R.string.artechouse_loc), R.drawable.artechouse1, "https://www.usa.artechouse.com/", getString(R.string.artechouse_info)));
        sites.add(new Site(getString(R.string.blind_whino), getString(R.string.blind_whino_loc), R.drawable.blindwhino1, "https://www.blindwhino.org/", getString(R.string.blind_whino_info)));
        sites.add(new Site(getString(R.string.dupont_underground), getString(R.string.dupont_underground_loc), R.drawable.dupontunderground, "https://www.dupontunderground.org/", getString(R.string.dupont_underground_info)));
        sites.add(new Site(getString(R.string.hirshhorn), getString(R.string.hirshhorn_loc), R.drawable.hirshhorn1, "https://hirshhorn.si.edu/", getString(R.string.hirshhorn_info)));
        sites.add(new Site(getString(R.string.nga), getString(R.string.nga_loc), R.drawable.nga1, "https://www.nga.gov/", getString(R.string.nga_info)));
        sites.add(new Site(getString(R.string.nmwa), getString(R.string.nmwa_loc), R.drawable.womensmuseum2, "https://nmwa.org/", getString(R.string.nmwa_info)));
        sites.add(new Site(getString(R.string.phillips), getString(R.string.phillips_loc), R.drawable.phillipscollection1, "http://www.phillipscollection.org/", getString(R.string.phillips_info)));
        sites.add(new Site(getString(R.string.renwick), getString(R.string.renwick_loc), R.drawable.renwickgallery, "https://americanart.si.edu/visit/renwick", getString(R.string.renwick_info)));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_art);

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