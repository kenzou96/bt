package com.vn.edu.poly.bt;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.ExampleViewHolder> {
    private List<latest> latestList;
    private Context context;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;



        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgA);




        }
    }

    public LatestAdapter(Context context, List<latest> latestList) {
        this.context = context;
        this.latestList = latestList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        final latest latest = latestList.get(position);

        //holder.mImageView.setImageResource(R.drawable.sutu);
        //holder.mTextView1.setText(category.getmText());
        Picasso.with(context).load(latest.getmImageResource()).into(holder.mImageView);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, category.getmText(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,ImageActivity.class);
//                intent.putExtra("Anh",category.getmImageResource());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return latestList.size();
    }
}
