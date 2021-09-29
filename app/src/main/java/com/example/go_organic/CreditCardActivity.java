package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class CreditCardActivity extends AppCompatActivity {

    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        pay = findViewById(R.id.btn_pay);
        String sAmount="100";
//        int amount= Math.round(Float.parseFloat(sAmount)*100);

        int amount = 1000;

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkout razorpay checkout
                Checkout checkout = new Checkout();

                //set key and id
                checkout.setKeyID("rzp_test_UcRikaqIqB5Aeu");
                //set image
                checkout.setImage(R.drawable.rzp_logo);
                //initialize json object
                JSONObject object = new JSONObject();


                try {
                    //put details
                    object.put("name","Go Organic");
                    object.put("description","Test Payment");
                    object.put("theme.color","#0000B9");
                    object.put("currency","LKR");
                    object.put("amount", amount);
                    object.put("prefill contact","+94719770636");
                    object.put("prefill email","goorganicinfo@gmail.com");

                    //open razor pay checkout activity
                    checkout.open(CreditCardActivity.this,object);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

  /* @Override
    public void onPaymentSuccess(String s) {
        //Initialize alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        //Display Toast
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }*/
}