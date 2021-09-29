package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentDetails extends AppCompatActivity implements View.OnClickListener {
    private Button button;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);


        b =  findViewById(R.id.button_cash_on_deliver);
        b.setOnClickListener(this);

        button = (Button) findViewById(R.id.buttton_credit_card);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeancredit_card();
            }
        });

    }
    /*public void opencash_on_deliver(){
        Intent intent = new Intent(this, cash_on_deliver.class);
        startActivity(intent);
    }*/

    public void opeancredit_card(){
        Intent intent = new Intent(this, CreditCardActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(PaymentDetails.this, "Confirm", Toast.LENGTH_SHORT).show();

    }
}
