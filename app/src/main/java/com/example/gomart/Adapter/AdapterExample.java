package com.example.gomart.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gomart.Model.Model_Foto;
import com.example.gomart.R;

import java.util.ArrayList;

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.AdapterViewHolder> {

String kata[] = {"masuk"};
    private ArrayList<Model_Foto> model_fotos;

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Image_CardView);


        }
    }


    public AdapterExample(ArrayList<Model_Foto> model_fotos1) {
        model_fotos = model_fotos1;
    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(view);
        return adapterViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {
        Model_Foto model_foto = model_fotos.get(i);
        adapterViewHolder.imageView.setImageResource(model_foto.getFhoto());


    }

    @Override
    public int getItemCount() {
        return model_fotos.size();
    }



}
