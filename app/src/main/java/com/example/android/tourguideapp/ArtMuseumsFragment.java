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
public class ArtMuseumsFragment extends Fragment {




    public ArtMuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site("National Gallery of Art", "6th & Constitution Ave NW", R.drawable.color_red, "https://www.nga.gov/", "Most extensive art museum in DC."));
        sites.add(new Site("Hirshhorn Museum and Sculpture Garden", "Independence Avenue at Seventh Street SW", R.drawable.hirshhorn1, "https://hirshhorn.si.edu/", "Interesting installations."));
        sites.add(new Site("The Phillips Collection", "1600 21st St NW", R.drawable.color_red, "http://www.phillipscollection.org/","Renoir's famous painting is here. Lots of impressionist paintings."));
        sites.add(new Site("Renwick Gallery", "1661 Pennsylvania Ave NW", R.drawable.renwickgallery, "https://americanart.si.edu/visit/renwick", "Interesting installations."));
        sites.add(new Site("National Portrait Gallery", "8th St NW & F St NW", R.drawable.color_red, "http://npg.si.edu/home/national-portrait-gallery","Portraits of famous people, presidents, and celebrities."));
        sites.add(new Site("Smithsonian American Art Museum", "F St NW & 8th St NW", R.drawable.color_red, "https://americanart.si.edu/","Great art from American artists, especially the modern art section."));
        sites.add(new Site("National Museum of Women in the Arts", "1250 New York Ave NW", R.drawable.color_red, "https://nmwa.org/","Thought-provoking art by women artists."));
        sites.add(new Site("Dupont Underground", "19 Dupont Cir NW", R.drawable.dupontunderground, "https://www.dupontunderground.org/","Former subway station turned gallery space."));
        sites.add(new Site("Artechouse", "1238 Maryland Ave SW", R.drawable.color_red, "https://www.usa.artechouse.com/","Where art and technology merge. Full scale interactive video installations."));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_art);

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