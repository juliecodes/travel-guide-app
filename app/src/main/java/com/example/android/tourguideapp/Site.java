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
 * {@link Site} represents a site that the user wants to visit.
 * It contains a title, location, information, url, and an image for that site.
 */
public class Site {

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * site title
     */
    private String mTitle;
    /**
     * site location
     */
    private String mLocation;
    /**
     * image resource ID for the site
     */

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * information about the site
     */
    private String mMoreInfo;

    /**
     * URL for the site's website or a Google map of its location.
     */
    private String mUrl;


    /**
     * Create a new Site object for murals category.
     *
     * @param title           is the title of the site
     * @param location        is the location of the site
     * @param imageResourceId is the photo for the site.
     * @param url             is the website or map location of the site
     * @param moreInfo        is more information for the site.
     */
    public Site(String title, String location, int imageResourceId, String url, String moreInfo) {
        mTitle = title;
        mLocation = location;
        mImageResourceId = imageResourceId;
        mUrl = url;
        mMoreInfo = moreInfo;

    }


    /**
     * Get the name of the site.
     */
    public String getSiteTitle() {
        return mTitle;
    }

    /**
     * Get the location of the site.
     */
    public String getLocation() {
        return mLocation;
    }


    /**
     * Get the image of the site.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this site.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the URL or Google map of the current site.
     */
    public String getUrl() {
        return mUrl;
    }

    public String getMoreInfo() {
        return mMoreInfo;
    }


}