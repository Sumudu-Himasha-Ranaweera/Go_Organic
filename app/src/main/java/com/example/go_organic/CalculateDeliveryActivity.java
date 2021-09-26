package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateDeliveryActivity extends AppCompatActivity {
    EditText distance, fee;
    TextView resulttext;
    String calculation, Cresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_delivery);

        distance = findViewById(R.id.distance);
        fee = findViewById(R.id.fee);
        resulttext = findViewById(R.id.result);
    }

    public void calculateDeliveryFee(View view) {
        String S1 = distance.getText().toString();
        String S2 = fee.getText().toString();

        float distanceValue = Float.parseFloat(S1);
        float feeValue = Float.parseFloat(S2);

        float c = distanceValue * feeValue;

        calculation = "Result : " + c;

        resulttext.setText(calculation);
    }

    public void btnGoBackViewDelivery(View view) {
        Intent intent = new Intent(this,ViewDeliveryActivity.class);
        startActivity(intent);
    }
}