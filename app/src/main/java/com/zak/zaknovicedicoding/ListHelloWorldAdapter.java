package com.zak.zaknovicedicoding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHelloWorldAdapter extends  RecyclerView.Adapter<ListHelloWorldAdapter.ListViewHolder>
{

    private ArrayList<HelloWorld> listHelloWorld;
    public ListHelloWorldAdapter(ArrayList<HelloWorld> list) {
        this.listHelloWorld = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hello_world, parent , false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        HelloWorld hw = listHelloWorld.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hw.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.hwName.setText(hw.getName());
        holder.hwDetail.setText(hw.getDetail());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                        listHelloWorld.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHelloWorld.get(holder.getAdapterPosition()));
            }
        });


    }

    public interface OnItemClickCallback {
        void onItemClicked(HelloWorld data);
    }


    @Override
    public int getItemCount() {
        return listHelloWorld.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView hwName, hwDetail;
        Button btnDetail;
        RecyclerView holder;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            hwName = itemView.findViewById(R.id.hw_item_name);
            hwDetail = itemView.findViewById(R.id.hw_item_detail);
            btnDetail = itemView.findViewById(R.id.btn_check_detail);
        }


    }
}
