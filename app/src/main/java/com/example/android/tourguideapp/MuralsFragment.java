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
        sites.add(new Site("Angel Wings", "2015 Massachusetts Ave NW", R.drawable.angelwings1, "https://goo.gl/maps/smwtuGkNaDp", "Artist: Colette Miller \nAt the Embassy Row Hotel"));
        sites.add(new Site("Currulao y Desplazamiento", "1344 U Street NW", R.drawable.currulao1, "https://goo.gl/maps/fTxtGZaJ5B72", "Artist: Joel Bergner \nBeautiful Afro-Colombian Mural."));
        sites.add(new Site("Every Day I See Something New", "1742 Kalorama Rd NW", R.drawable.everydayisee1, "https://goo.gl/maps/eCMgW7xPaXH2", "Artist: Cita Sadeli CHELOVE"));
        sites.add(new Site("Marvin 2014", "S Street NW and 7th Street NW", R.drawable.marvinmural, "https://goo.gl/maps/KBHKk8dPPL32", "Artist: Aneikan Udofo"));
        sites.add(new Site("Mermaid", "635 North Carolina Ave SE", R.drawable.mermaid1, "https://goo.gl/maps/atEhRv7n5V12", "Artist: Aniekan Udofia"));
        sites.add(new Site("Presidential mural", "1984 Calvert Street NW", R.drawable.presidential1, "https://goo.gl/maps/RyRym1pdKa82", "Artist: Karla Cecilia Rodas Cortez \"Karlisima.\""));
        sites.add(new Site("Shop Small 2014", "Near Adams Morgan garage", R.drawable.shopsmall2014_2, "https://goo.gl/maps/jFbkF1amTQC2", "Artist: Aniekan Udofia \nAlley between Amsterdam Falafelshop and Little Shop of Flowers."));
        sites.add(new Site("Space is the Place", "Blagden Alley", R.drawable.space, "https://goo.gl/maps/JzrWKfNzT3n", "Artists: Aniekan Udofia with Mia Duval"));
        sites.add(new Site("The Torch", "1213 U St NW", R.drawable.thetorch1, "https://goo.gl/maps/SvhAX8Yh7ao", "Artists: Aniekan Udofia with Mia Duval"));


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