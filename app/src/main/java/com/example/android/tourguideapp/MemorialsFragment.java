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
public class MemorialsFragment extends Fragment {




    public MemorialsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site("Franklin Delano Roosevelt Memorial", "1850 West Basin Dr SW", R.drawable.fdr1, "https://www.nps.gov/frde/index.htm","This memorial features waterfalls."));
        sites.add(new Site("Korean War Veterans Memorial", "900 Ohio Dr SW", R.drawable.koreanwar3, "https://www.nps.gov/kowa/index.htm", "I stumbled upon this by accident one day. Really moving memorial."));
        sites.add(new Site("Lincoln Memorial", "2 Lincoln Memorial Cir NW", R.drawable.lincoln1, "https://www.nps.gov/linc/index.htm", "The most iconic landmark in Washington, next to the Washington Monument."));
        sites.add(new Site("Library of Congress", "101 Independence Ave SE", R.drawable.librarycongress1, "https://www.loc.gov/","Not a tradtional memorial, but it is a beautiful historic building."));
        sites.add(new Site("Martin Luther King Memorial", "1964 Independence Ave SW", R.drawable.mlk1, "https://www.nps.gov/mlkm/planyourvisit/basicinfo.htm","Inspiring memorial in the tidal basin."));
        sites.add(new Site("National World War II Memorial", "1750 Independence Ave SW", R.drawable.wwiimemorial4, "https://www.nps.gov/wwii/index.htm","This memorial features a fountain that lights up at night."));
        sites.add(new Site("Thomas Jefferson Memorial", "701 E Basin Dr SW", R.drawable.jeffersonmemorial1, "https://www.nps.gov/thje/index.htm","Gorgeous memorial best visited during cherry blossom season"));
        sites.add(new Site("Washington Monument", "2 15th St NW", R.drawable.washingtonmonument2, "https://www.nps.gov/wamo/index.htm", "The most iconic landmark in Washington, next to the Lincoln Memorial."));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_memorials);

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