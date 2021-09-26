package com.example.go_organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.go_organic.adapters.NavCategoryDetailAdapter;
import com.example.go_organic.models.NavCategoryDetailModel;
import com.example.go_organic.models.Popular_ProductsModel;
import com.example.go_organic.models.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NavCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NavCategoryDetailModel> list;
    NavCategoryDetailAdapter adapter;

    FirebaseFirestore db;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_category);

        db = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.nav_cat_det_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.GONE);

        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        list = new ArrayList<>();
        adapter = new NavCategoryDetailAdapter(this,list);

        //getting fruits products
        if(type != null && type.equalsIgnoreCase("Fruits")) {
            db.collection("NavCategoryDetails").whereEqualTo("type", "Fruits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailModel viewAllModel = documentSnapshot.toObject(NavCategoryDetailModel.class);
                        list.add(viewAllModel);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        //getting Vegetable products
        if(type != null && type.equalsIgnoreCase("Vegetables")) {
            db.collection("NavCategoryDetails").whereEqualTo("type", "Vegetables").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailModel viewAllModel = documentSnapshot.toObject(NavCategoryDetailModel.class);
                        list.add(viewAllModel);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        //getting Green & Herbs products
        if(type != null && type.equalsIgnoreCase("Green & Herbs")) {
            db.collection("NavCategoryDetails").whereEqualTo("type", "Green & Herbs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailModel viewAllModel = documentSnapshot.toObject(NavCategoryDetailModel.class);
                        list.add(viewAllModel);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        //getting Diary products
        if(type != null && type.equalsIgnoreCase("Diary & Eggs")) {
            db.collection("NavCategoryDetails").whereEqualTo("type", "Diary & Eggs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailModel viewAllModel = documentSnapshot.toObject(NavCategoryDetailModel.class);
                        list.add(viewAllModel);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

        //getting Salad products
        if(type != null && type.equalsIgnoreCase("salad")) {
            db.collection("NavCategoryDetails").whereEqualTo("type", "salad").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        NavCategoryDetailModel viewAllModel = documentSnapshot.toObject(NavCategoryDetailModel.class);
                        list.add(viewAllModel);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                }
            });
        }

    }
}