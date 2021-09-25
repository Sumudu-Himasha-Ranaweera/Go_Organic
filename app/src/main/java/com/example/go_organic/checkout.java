package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class checkout<AwesomeValidation> extends AppCompatActivity {
    //Initialize Variables
    EditText ReceiverName, etAddress, etNumber;
    Button btnPlaceOrder;
    private String totalAmount ="";



    AwesomeValidation awesomeValidation;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    //public static final String totalAmount = "Total Amount";
    private TextView totalText;
    private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        totalAmount = intent.getStringExtra("Total");
        Toast.makeText(this, "Total Amount : LKR"+ totalAmount,Toast.LENGTH_SHORT);

        //Assign Variables
        ReceiverName = findViewById(R.id.ptName);
        etAddress = findViewById(R.id.ptAddress);
        etNumber = findViewById(R.id.ptContact);
        btnPlaceOrder = findViewById(R.id.buttonPlaceOrder);
        totalText = findViewById(R.id.txtTotalToPay);
        //save data in Firebase on Place Order button click


        totalText.setText("Total Amount" +  totalAmount );

        btnPlaceOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Delivery Details" );

                String name = ReceiverName.getText().toString();
                String address = etAddress.getText().toString();
                String contact = etNumber.getText().toString();


                DeliverDetailsHelper helper = new DeliverDetailsHelper(name, address,contact);
                //reference.child(contact).setValue(helper);
                reference.child(Long.toString(System.currentTimeMillis())).setValue(helper);


            }
        });

        //Intent mIntent = getIntent();
        //int overTotalPrice = mIntent.getIntExtra("Total Amount :", 0);

    }

}