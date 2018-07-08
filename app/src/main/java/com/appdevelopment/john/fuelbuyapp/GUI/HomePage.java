package com.appdevelopment.john.fuelbuyapp.GUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appdevelopment.john.fuelbuyapp.R;

public class HomePage extends AppCompatActivity {

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
        Intent intent = new Intent(this, FuelInfoPage.class);
        startActivity(intent);
    }
}
