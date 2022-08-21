package com.example.navigationdrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class CustomRecyclerViewAdopter extends RecyclerView.Adapter {
    ArrayList personNames;
    ArrayList personImages;
    Context context;
    public CustomRecyclerViewAdopter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        MyViewHolder viewHolder= (MyViewHolder)holder;
        ((MyViewHolder) holder).name.setText( personNames.get(position).toString());
        ((MyViewHolder) holder).image.setImageResource((Integer) personImages.get(position));

        // implement setOnClickListener event on item view.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {

                    case 0:
                        Intent viewIntent =
                                new Intent("android.intent.action.VIEW",
                                        Uri.parse("http://www.stackoverflow.com/"));
                        context.startActivity(viewIntent);
                        break;

                    case 1:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
                        context.startActivity(browserIntent);
                        Toast.makeText(context, "Chemistry ", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(context, "Mathematics ", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(context, "Biology ", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(context, "English ", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(context, "Hindi ", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(context, "PET ", Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(context, "SSC ", Toast.LENGTH_LONG).show();


                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return personNames.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
