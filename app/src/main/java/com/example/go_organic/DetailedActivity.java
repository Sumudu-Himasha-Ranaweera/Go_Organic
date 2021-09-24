package com.example.go_organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.go_organic.models.ViewAllModel;

public class DetailedActivity extends AppCompatActivity {

    TextView quantity;
    int totalQuantity = 1;
    int totalPrice = 0;

    ImageView detailedImg,addItem,removeItem;
    TextView price,rating;
    Button addtoCart;
    Toolbar toolbar;

    ViewAllModel viewAllModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof ViewAllModel){
            viewAllModel = (ViewAllModel) object;
        }

        quantity = findViewById(R.id.detailed_quantity);
        detailedImg = findViewById(R.id.detailed_img);
        addItem = findViewById(R.id.add_item);
        removeItem = findViewById(R.id.remove_item);
        price = findViewById(R.id.detailed_price);
        rating = findViewById(R.id.detailed_rating);

        if (viewAllModel != null){
            Glide.with(getApplicationContext()).load(viewAllModel.getImg_url()).into(detailedImg);
            rating.setText(viewAllModel.getRating());
            price.setText("Price Rs: "+viewAllModel.getPrice()+"/ 1KG");

            totalPrice = viewAllModel.getPrice() * totalQuantity;

            if (viewAllModel.getType().equals("Diary & Eggs")){
                price.setText("Price Rs: "+viewAllModel.getPrice()+"/dozen");
                totalPrice = viewAllModel.getPrice() * totalQuantity;
            }

            if (viewAllModel.getType().equals("Fruits")){
                price.setText("Price Rs: "+viewAllModel.getPrice()+"/500g");
                totalPrice = viewAllModel.getPrice() * totalQuantity;
            }

            if (viewAllModel.getType().equals("salad")){
                price.setText("Price Rs: "+viewAllModel.getPrice()+"/100g");
                totalPrice = viewAllModel.getPrice() * totalQuantity;
            }

            if (viewAllModel.getType().equals("Green & Herbs")){
                price.setText("Price Rs: "+viewAllModel.getPrice()+"/100g");
                totalPrice = viewAllModel.getPrice() * totalQuantity;
            }

        }
        addtoCart = findViewById(R.id.add_to_cart);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (totalQuantity < 9){
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                }

            }
        });
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (totalQuantity > 1){
                    totalQuantity--;
                    quantity.setText(String.valueOf(totalQuantity));
                }

            }
        });
    }

}