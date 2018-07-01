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
        sites.add(new Site("National Gallery of Art", "1213 U St NW", R.drawable.color_red, "https://goo.gl/maps/SvhAX8Yh7ao", "Most extensive art museum in DC."));
        sites.add(new Site("Hirshhorn Museum and Sculpture Garden", "1742 Kalorama Rd NW", R.drawable.color_red, "https://goo.gl/maps/eCMgW7xPaXH2", "Interesting installations"));
        sites.add(new Site("Philips Collection", "635 North Carolina Ave SE", R.drawable.color_red, "https://goo.gl/maps/atEhRv7n5V12","Renoir's famous painting is here. Lots of Impressionist paintings."));
        sites.add(new Site("Renwick Gallery", "S Street NW and 7th Street NW", R.drawable.color_red, "https://goo.gl/maps/KBHKk8dPPL32", "One of my favorite."));
        sites.add(new Site("National Portrait Gallery", "1112 Q St NW", R.drawable.color_red, "https://goo.gl/maps/zWVkXGbhnVu","Artist: house owners"));
        sites.add(new Site("American Museum of Art", "2015 Massachusetts Ave NW", R.drawable.color_red, "https://goo.gl/maps/smwtuGkNaDp","Artist: Colette Miller \n\nAt the Embassy Row Hotel"));
        sites.add(new Site("National Museum of Women in the Arts", "1984 Calvert Street NW", R.drawable.color_red, "https://goo.gl/maps/RyRym1pdKa82","Artist: Karla Cecilia Rodas Cortez \"Karlisima.\""));
        sites.add(new Site("Long View Gallery", "Blagden Alley", R.drawable.color_red, "https://goo.gl/maps/JzrWKfNzT3n","Artists: Aniekan Udofia with Mia Duval"));
        sites.add(new Site("Touchstone Gallery", "1344 U Street NW", R.drawable.color_red, "https://goo.gl/maps/fTxtGZaJ5B72","Artist: Joel Bergner"));
        sites.add(new Site("Joan Hisoaka Healing Arts Gallery", "Near Adams Morgan garage", R.drawable.color_red, "https://goo.gl/maps/jFbkF1amTQC2","Artist: Aniekan Udofia \n\nAlley between Amsterdam Falafelshop and Little Shop of Flowers."));


        // Create an {@link SiteAdapter}, whose data source is a list of {@link Site}s. The
        // adapter knows how to create list items for each item in the list.
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_colors);

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