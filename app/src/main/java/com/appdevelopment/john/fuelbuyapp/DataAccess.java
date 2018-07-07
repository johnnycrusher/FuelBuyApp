package com.appdevelopment.john.fuelbuyapp;

import org.json.simple.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.StringBuilder;


public class DataAccess {
    private String postcode;
    private String fuel;
    private String URL;
    private URL url;
    private StringBuffer response;
    private JSONArray jsonData;

    public DataAccess(int postCode, String fuelType) throws MalformedURLException {
        this.postcode = Integer.toString(postCode);
        this.fuel = fuelType;
        StringBuilder builder = new StringBuilder();
        final String  baseURL = "http://localhost:8000/?";
        String postCodeFlag = "Postcode=";
        String fuelFlag = "Fuel=";
        String querySeperator = "&";
        if(!(fuel.equals("")) && !(postcode.equals(""))){
            builder.append(baseURL);
            builder.append(postCodeFlag);
            builder.append(postcode);
            builder.append(querySeperator);
            builder.append(fuelFlag);
            builder.append(fuel);
        }
        this.URL = builder.toString();
        this.url = new URL(URL);
        this.response = new StringBuffer();
    }





}
