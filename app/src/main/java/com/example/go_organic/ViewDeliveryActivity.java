package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewDeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

       /* String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("A111");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("A111");
        } */

    }

    public void btnviewLocation(View view) {
        Intent intent = new Intent(this,MapTrackingActivity.class);
        startActivity(intent);
    }

    public void btnGoBackDelivery(View view) {
        Intent intent = new Intent(this,DeliveryActivity.class);
        startActivity(intent);
    }

    public void btnCalDelivery(View view) {
        Intent intent = new Intent(this,CalculateDeliveryActivity.class);
        startActivity(intent);
    }
}