package com.example.go_organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CompletedDeliveryActivity extends AppCompatActivity {

    //Initialize variable
    EditText etValue;
    Button btAdd;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String sOldValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_delivery);

        //Assign variable
        etValue = findViewById(R.id.et_value);
        btAdd = findViewById(R.id.bt_add);
        listView = findViewById(R.id.list_view);



        //initialize adapter
        adapter = new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1,arrayList);


        //initialize database
        firebaseDatabase = FirebaseDatabase.getInstance();
        //initialize database reference
        databaseReference = firebaseDatabase.getReference().child("Completed Delivery History");

        //Create method
        getValue();


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value from edit text
                String sValue = etValue.getText().toString().trim();
                //check condition
                if(btAdd.getText().equals("Add")){
                    //when user want to add new value
                    //Initialize  unique key
                    String sKey = databaseReference.push().getKey();
                    //Check condition
                    if (sKey != null){
                        //When key not equal to null
                        //Add value with key name
                        databaseReference.child(sKey).child("Completed Delivery History").setValue(sValue);
                        //clear edit text value
                        etValue.setText("");
                    }

                }else {
                    //when user want to update existing value
                    //initialize query
                    Query query = databaseReference.orderByChild("Completed Delivery History")
                            .equalTo(sOldValue);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            //use for loop
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                //update value
                                dataSnapshot.getRef().child("Completed Delivery History").setValue(sValue);
                                //clear edit text value
                                etValue.setText("");
                                //change button text
                                btAdd.setText("Add");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }
            }
        });


        //ish update
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 //Get selected value from the list
                 sOldValue = arrayList.get(position);
                 //set value on edit text
                 etValue.setText(sOldValue);
                 //change button text
                 btAdd.setText("Update");
             }
         });

          listView.setOnItemLongClickListener(new OnItemLongClickListener() {
              @Override
              public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                  //Get value from list
                  String s = arrayList.get(position);
                  //initialize alert dialog
                  AlertDialog.Builder builder = new AlertDialog.Builder(
                          CompletedDeliveryActivity.this
                  );
                  //set title
                  builder.setTitle("Confirm Delete");
                  //set message
                  builder.setMessage("Are you sure you want to delete selected data?");
                  //set positive button
                  builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int which) {
                          //initialize query
                          Query query = databaseReference.orderByChild("Completed Delivery History")
                                  .equalTo(s);
                          query.addListenerForSingleValueEvent(new ValueEventListener() {
                              @Override
                              public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                  //use for loop
                                  for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                      //remove value
                                      dataSnapshot.getRef().removeValue();
                                  }
                              }

                              @Override
                              public void onCancelled(@NonNull @NotNull DatabaseError error) {

                              }
                          });
                      }
                  });
                  //set negative button
                  builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          //Dismiss dialog
                          dialog.dismiss();
                      }
                  });
                  //display  dialog
                  builder.show();
                  //pass true value
                  return true;
              }
          });





    }

    private void getValue() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Clear array list
                arrayList.clear();
                //Use  for loop
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    //Get  value
                    String sValue = dataSnapshot.child("Completed Delivery History").getValue(String.class);
                    //Add value in array list
                    arrayList.add(sValue);
                }
                //Set adapter
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    //Display toast
                Toast.makeText(
                        getApplicationContext()
                        ,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void back_com(View view) {
        Intent intent = new Intent(this,DeliveryActivity.class);
        startActivity(intent);
    }
}