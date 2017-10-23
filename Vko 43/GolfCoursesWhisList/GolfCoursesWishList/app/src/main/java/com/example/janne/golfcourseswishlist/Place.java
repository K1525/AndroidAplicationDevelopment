package com.example.janne.golfcourseswishlist;

/**
 * Created by Janne on 23.10.2017.
 */

import android.content.Context;

/**
 * Created by Janne on 23.10.2017.
 */

public class Place {
    public String name;
    public String imageName;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
