package com.appdevelopment.john.fuelbuyapp.GUI;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appdevelopment.john.fuelbuyapp.Exceptions.EmptyStringException;
import com.appdevelopment.john.fuelbuyapp.NetworkRequest.DataAccess;
import com.appdevelopment.john.fuelbuyapp.R;
import android.util.Log;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;


public class FuelInfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_info_page);
        Intent intent = getIntent();
        int postcode = intent.getIntExtra(HomePage.EXTRA_NUMBER,0);
        String fuelType = intent.getStringExtra(HomePage.EXTRA_TEXT);

        MyParams myParams = new MyParams(postcode,fuelType);
        executeDataAccess  DataAccessThread = new executeDataAccess();
        DataAccessThread.execute(myParams);
//        Log.i("Postcode",Integer.toString(postcode));
//        Log.i("FuelType", fuelType);

    }
    private static class MyParams{
        int postcode;
        String fuelType;

        public MyParams(int postcode, String fuelType){
            this.postcode = postcode;
            this.fuelType = fuelType;
        }
    }

    private class executeDataAccess extends AsyncTask<MyParams,Void,DataAccess>{
        String [][] tableElements;
        @Override
        protected DataAccess doInBackground(MyParams... myParams){
            DataAccess connection = null;
            try{
                connection = new DataAccess(myParams[0].postcode,myParams[0].fuelType);
                connection.getRequest();
                connection.parseJSONToJSONArray();
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(EmptyStringException eString){
                eString.printStackTrace();
            }catch(IOException eIO){
                eIO.printStackTrace();
            }catch(ParseException eParse){
                eParse.printStackTrace();
            }
            return connection;
        }

        @Override
        protected void onPostExecute(DataAccess dataAccess) {
            super.onPostExecute(dataAccess);
            Log.i("Hello", "randomlogShit");
        }
    }
}
