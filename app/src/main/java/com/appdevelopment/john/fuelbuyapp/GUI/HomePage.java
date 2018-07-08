package com.appdevelopment.john.fuelbuyapp.GUI;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.appdevelopment.john.fuelbuyapp.R;

public class HomePage extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.appdevelopment.john.fuelbuyapp.EXTRA_STRING";
    public static final String EXTRA_NUMBER = "com.appdevelopment.john.fuelbuyapp.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        Button button = (Button) findViewById(R.id.submitBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFuelInfoPage();
            }
        });
    }
    public void openFuelInfoPage(){
        TextInputEditText postcodeInput = (TextInputEditText) findViewById(R.id.postcode);
        int postcodeInteger = Integer.parseInt(postcodeInput.getText().toString());

        Spinner fuelSpinner = (Spinner) findViewById(R.id.fuelTypeSpinner);
        String fuelTypeString = fuelSpinner.getSelectedItem().toString();
//        Log.i("Postcode:",Integer.toString(postcodeInteger));
//        Log.i("Fuel Type:", fuelTypeString);

        Intent intent = new Intent(this, FuelInfoPage.class);
        intent.putExtra(EXTRA_NUMBER, postcodeInteger);
        intent.putExtra(EXTRA_TEXT,fuelTypeString);
        startActivity(intent);
    }
}
