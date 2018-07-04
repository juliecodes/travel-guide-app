package com.example.android.tourguideapp;

/**
 * CREDITS:
 *
 * CURRULAO Y DESPLAZAMIENTO, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/afagen/16246399561/
 *
 * SHOP SMALL, cropped to square
 * CC BY-NC-SA 2.0
 * https://www.flickr.com/photos/thisisbossi/33131778215/
 *
 * THE TORCH, cropped to square
 * Public Domain
 * https://www.flickr.com/photos/daquellamanera/35593753711/
 *
 * Licenses:
 *
 * CC BY-NC-SA 2.0
 * https://creativecommons.org/licenses/by-nc-sa/2.0/
 *
 * Public Domain
 * https://creativecommons.org/publicdomain/zero/1.0/
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
public class MuralsFragment extends Fragment {


    public MuralsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.angel), getString(R.string.angel_loc), R.drawable.angelwings1, "https://goo.gl/maps/smwtuGkNaDp", getString(R.string.angel_info)));
        sites.add(new Site(getString(R.string.currulao), getString(R.string.currulao_loc), R.drawable.currulao1, "https://goo.gl/maps/fTxtGZaJ5B72", getString(R.string.currulao_info)));
        sites.add(new Site(getString(R.string.everyday), getString(R.string.everyday_loc), R.drawable.everydayisee1, "https://goo.gl/maps/eCMgW7xPaXH2", getString(R.string.everyday_info)));
        sites.add(new Site(getString(R.string.marvin), getString(R.string.marvin_loc), R.drawable.marvinmural, "https://goo.gl/maps/KBHKk8dPPL32", getString(R.string.marvin_info)));
        sites.add(new Site(getString(R.string.mermaid), getString(R.string.mermaid_loc), R.drawable.mermaid1, "https://goo.gl/maps/atEhRv7n5V12", getString(R.string.mermaid_info)));
        sites.add(new Site(getString(R.string.presidential), getString(R.string.presidential_loc), R.drawable.presidential1, "https://goo.gl/maps/RyRym1pdKa82", getString(R.string.presidential_info)));
        sites.add(new Site(getString(R.string.shop_small), getString(R.string.shop_small_loc), R.drawable.shopsmall2014_2, "https://goo.gl/maps/jFbkF1amTQC2", getString(R.string.shop_small_info)));
        sites.add(new Site(getString(R.string.space), getString(R.string.space_loc), R.drawable.space, "https://goo.gl/maps/JzrWKfNzT3n", getString(R.string.space_info)));
        sites.add(new Site(getString(R.string.torch), getString(R.string.torch_loc), R.drawable.thetorch1, "https://goo.gl/maps/SvhAX8Yh7ao", getString(R.string.torch_info)));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_murals);

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