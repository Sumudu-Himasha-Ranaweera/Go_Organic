package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class DeliveryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DeliveryAdapter deliveryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        recyclerView =  (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(DeliveryActivity.this, "Firebase is success",Toast.LENGTH_LONG).show();

        FirebaseRecyclerOptions<DeliveryModel> options =
                new FirebaseRecyclerOptions.Builder<DeliveryModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Delivery Details"), DeliveryModel.class)
                        .build();

        deliveryAdapter = new DeliveryAdapter(options);
        recyclerView.setAdapter(deliveryAdapter);
    }



    @Override
    protected void onStart() {
        super.onStart();
        deliveryAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        deliveryAdapter.stopListening();
    }
}