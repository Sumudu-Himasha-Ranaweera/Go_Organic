package com.example.go_organic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import de.hdodenhof.circleimageview.CircleImageView;

public class CartAdapter extends FirebaseRecyclerAdapter<CartModel,CartAdapter.myViewHolder> {

    int overTotalPrice=0;
    TextView txtTotalAmount;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CartAdapter(@NotNull FirebaseRecyclerOptions<CartModel> options) {
        super(options);


    }

    @Override
    protected void onBindViewHolder(@NotNull myViewHolder holder, int position, @NotNull CartModel model) {
        holder.product.setText(model.getProduct());
        holder.price.setText(model.getPrice());
        holder.quantity.setText(model.getQuantity());

        int oneTypeProductTPrice = ((Integer.valueOf(model.getPrice())))*Integer.valueOf(model.getQuantity());
        overTotalPrice = overTotalPrice + oneTypeProductTPrice;

        Glide.with(holder.img.getContext())
                .load(model.getCurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


        holder.btnCEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.cart_update_popup))
                        .setExpanded(true, 1200)
                        .create();
                dialogPlus.show();
                View view = dialogPlus.getHolderView();
                EditText quantity = view.findViewById(R.id.txtCQuantity);

                Button btnCUpdate = view.findViewById(R.id.btnCUpdate);

                quantity.setText(model.getQuantity());

                dialogPlus.show();

                btnCUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("Quantity",quantity.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Cart Items")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.quantity.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.quantity.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();

                                    }
                                });

                    }
                });

            }
        });

        holder.btnCDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.quantity.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Cart Items").child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.quantity.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }


    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent, false);
        return new myViewHolder(view);


    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView product, quantity, price;

        Button btnCEdit, btnCDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.cartimg1);
            product = (TextView)itemView.findViewById(R.id.pNameText);
            quantity = (TextView)itemView.findViewById(R.id.CQuantity);
            price= (TextView)itemView.findViewById(R.id.CPrice);

            btnCEdit = (Button)itemView.findViewById(R.id.CBtnEdit);
            btnCDelete= (Button)itemView.findViewById(R.id.CBtnDelete);


        }
    }

}
