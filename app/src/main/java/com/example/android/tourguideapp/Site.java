/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.tourguideapp;

/**
 * {@link Site} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and an image for that word.
 */
public class Site {

    /** Default translation for the word */
    private String mTitle;

    /** Miwok translation for the word */
    private String mLocation;

    /**  image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

   private String mArtist;


    /**
     * Create a new Site object.
     *
     * @param title is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param location is the word in the Miwok language
     *
     *
     */
    public Site(String title, String location, int imageResourceId) {
        mTitle = title;
        mLocation = location;
       mImageResourceId = imageResourceId;

    }

    /**
     * Create a new Site object.
     *
     * @param title is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param location is the word in the Miwok language
     *
     *  @param imageResourceId is the image for that word
     *
     *
     */
    public Site(String title, String location, int imageResourceId, String artist) {
        mTitle = title;
        mLocation = location;
        mImageResourceId = imageResourceId;
        mArtist = artist;

    }


    /**
     * Get the default translation of the word.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getLocation() {
        return mLocation;
    }



    /**
     * Get the image of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}