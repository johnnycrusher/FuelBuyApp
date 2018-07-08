package com.appdevelopment.john.fuelbuyapp.GUI;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appdevelopment.john.fuelbuyapp.NetworkRequest.DataAccess;
import com.appdevelopment.john.fuelbuyapp.R;
import android.util.Log;


public class FuelInfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_info_page);
        Intent intent = getIntent();
        int postcode = intent.getIntExtra(HomePage.EXTRA_NUMBER,0);
        String fuelType = intent.getStringExtra(HomePage.EXTRA_TEXT);

//        Log.i("Postcode",Integer.toString(postcode));
//        Log.i("FuelType", fuelType);

    }

//    private class executeDataAccess extends AsyncTask<Void,Void,Void>{
//        String [][] tableElements;
//        @Override
//        protected Void doInBackground(Void... arg0){
//            DataAccess connection = new DataAccess(postcode);
//
//        }
//    }
}
