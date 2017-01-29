package com.example.abuosama.contentproviderclient;

import android.net.Uri;

/**
 * Created by Abu Osama on 29-01-2017.
 */

//this file well be  exposed to outside world
//URI - Uniform Resource Identifier
//declare column name and prepare URIs for your table
public class UriProvider {
    //column names for first table
    public static final String _ID = "_id";//integer
    public  static  final String NAME="sname";//string
    public  static  final String SUB="ssub";//string

    // prepare URL for Student information table
    public static final Uri Student_URi=Uri.parse("content://com.abuosama/student");
}


