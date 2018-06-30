package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class MuralsFragment extends Fragment {




    public MuralsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site("The Torch", "1213 U St NW", R.drawable.color_red, "Aniekan Udofia with Mia Duval"));
        sites.add(new Site("Every Day I See Something New", "1742 Kalorama Rd NW", R.drawable.color_red, "Cita Sadeli CHELOVE"));
        sites.add(new Site("Mermaid", "635 North Carolina Ave SE", R.drawable.color_red, "Aniekan Udofia"));
        sites.add(new Site("Marvin 2014", "S Street NW, between 7th & 8th streets", R.drawable.color_red, "Aneikan Udofo"));
        sites.add(new Site("Watermelon House", "1112 Q St NW", R.drawable.color_red, "house owners"));
        sites.add(new Site("Angel Wings", "Embassy Row Hotel", R.drawable.color_red, "Colette Miller"));
        sites.add(new Site("Presidential mural", "1984 Calvert Street NW", R.drawable.color_red, "Karla Cecilia Rodas Cortez \"Karlisima.\""));
        sites.add(new Site("Blagden Alley mural", "Blagden Alley", R.drawable.color_red, "Aniekan Udofia with Mia Duval"));
        sites.add(new Site("Birth of Our Dreams", "1375 Missouri Ave NW", R.drawable.color_red, "Cecilia Lueza"));
        sites.add(new Site("Shop Small 2014", "Adams Morgan parking garage", R.drawable.color_red, "Aniekan Udofia"));


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
                Site site = sites.get(position);


            }
        });

        return rootView;
    }



}