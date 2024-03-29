package com.appdevelopment.john.fuelbuyapp.NetworkRequest;

import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.appdevelopment.john.fuelbuyapp.Exceptions.EmptyStringException;


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
        final String  baseURL = "http://192.168.1.94:8000/?";
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

    public void getRequest() throws IOException, EmptyStringException {
        if (URL.equals("")) {
            throw new EmptyStringException("URL is not defined");
        } else {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(10000);
            con.setConnectTimeout(10000);
            con.setRequestMethod("GET");
            con.connect();
            int responseCode = con.getResponseCode();
            Log.i("Sending 'GET' request", URL);
            Log.i("Response Code", Integer.toString(responseCode));

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                this.response.append(inputLine);
            }
            in.close();
        }
    }

    public String getURLString() throws EmptyStringException{
        if(URL.equals("")) {
            throw new EmptyStringException("URL String is Empty");
        }else {
            return URL;
        }
    }

    public void parseJSONToJSONArray() throws ParseException, EmptyStringException {
        if(response.toString().equals("")) {
            throw new EmptyStringException("No Response Data Collected");
        }else {
            JSONParser parser = new JSONParser();
            this.jsonData = (JSONArray)parser.parse(response.toString());
        }
    }

    public JSONObject getJSONObject(int index) {
        return (JSONObject) jsonData.get(index);
    }

    public String getJSONEntry (int row, String key) {
        JSONObject rowData = (JSONObject) jsonData.get(row);
        return (String) rowData.get(key);
    }

    public int getLengthOfJSON() {
        return jsonData.size();
    }

    public int getLengthOfJSONRow(int row) {
        JSONObject rowData = (JSONObject) jsonData.get(row);
        return rowData.size();
    }

    public String getKeyValue(int row, int column) {
        JSONObject rowData = (JSONObject) jsonData.get(row);
        ArrayList<String> keyArrayList = new ArrayList<String>();
        for(Object key: rowData.keySet()) {
            keyArrayList.add((String) key);
        }
        return keyArrayList.get(column);
    }
}
