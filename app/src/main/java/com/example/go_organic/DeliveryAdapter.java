package com.example.go_organic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeliveryAdapter extends FirebaseRecyclerAdapter<DeliveryModel,DeliveryAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DeliveryAdapter(@NonNull @NotNull FirebaseRecyclerOptions<DeliveryModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DeliveryModel model) {
        holder.name.setText(model.getName());
        holder.contact.setText(model.getContact());
        holder.address.setText(model.getAddress());

       /* Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img); */


     /*   holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),ViewDeliveryActivity.class);
                    String name1 = "AB";
                    i.putExtra("A111",name1);
                    String address1 = "ab";
                    i.putExtra("A111",address1);

                    String name2 = "CD";
                    i.putExtra("A222",name2);
                    String address2 = "cd";
                    i.putExtra("A222",address2);

                    String name3 = "EF";
                    i.putExtra("A333",name3);
                    String address3 = "ef";
                    i.putExtra("A333",address3);

                    String name4 = "GH";
                    i.putExtra("A444",name4);
                    String address4 = "gh";
                    i.putExtra("A444",address4);


                    String name5 = "IJ";
                    i.putExtra("A555",name5);
                    String address5 = "ij";
                   i.putExtra("A555",address5);

            }
        });  */

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent specPage= new Intent(v.getContext(), ViewDeliveryActivity.class);
                v.getContext().startActivity(specPage);

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Delivery Details")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.name.getContext(), "Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{


        CircleImageView img;
        TextView name,contact,address;

        Button btnView;
        Button btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);


            img =  (CircleImageView)itemView.findViewById(R.id.img1);
            name =  (TextView)itemView.findViewById(R.id.nametext);
            contact = (TextView)itemView.findViewById(R.id.contacttext);
            address = (TextView)itemView.findViewById(R.id.addresstext);

            btnView = (Button)itemView.findViewById(R.id.btnView);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);



        }
    }
}
