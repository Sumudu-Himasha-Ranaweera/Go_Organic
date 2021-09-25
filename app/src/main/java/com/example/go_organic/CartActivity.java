package com.example.go_organic;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    private Button button1;
    private Button button2;
    TextView txtTotalAmount;
    EditText checkTotalAmount;
    private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //firestore = FirebaseFirestore.getInstance();
        //auth = FirebaseAuth.getInstance();

        recyclerView = (RecyclerView)findViewById(R.id.M_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));


        FirebaseRecyclerOptions<CartModel> options =
                new FirebaseRecyclerOptions.Builder<CartModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Cart Items"), CartModel.class)
                        .build();

        cartAdapter = new CartAdapter(options);
        recyclerView.setAdapter(cartAdapter);

        Context context;
        Toast.makeText(CartActivity.this, "Firebase connection success", Toast.LENGTH_LONG).show();

        txtTotalAmount= (TextView) findViewById(R.id.CartTotalAmount);
        button2 =(Button) findViewById(R.id.M_Calculate);


        button1 = (Button) findViewById(R.id.ReadyToCheckout);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opencheckout();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTotal();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cartAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cartAdapter.stopListening();
    }

    public void opencheckout(){
        Intent intent = new Intent(this, checkout.class);
        intent.putExtra("Total", String.valueOf(cartAdapter.overTotalPrice));
        startActivity(intent);
    }

    public void calculateTotal(){
        txtTotalAmount.setText("Total Amount : LKR"+String.valueOf(cartAdapter.overTotalPrice));

    }

}