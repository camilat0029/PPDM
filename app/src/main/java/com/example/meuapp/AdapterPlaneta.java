package com.example.meuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterPlaneta extends ArrayAdapter<Planeta> {


    Context lcontext;

    public AdapterPlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        lcontext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Inflar o Layout xml
        LayoutInflater inflater = LayoutInflater.from(lcontext);
        View itemView=inflater.inflate(R.layout.item_lista,parent, false);
        // imageView + TextView



        //Preencher o item da listagem na variavel view
        TextView tvNome = itemView.findViewById(R.id.textView);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView tvMassa = itemView.findViewById(R.id.textView3);
        Planeta p = getItem(position);
        tvNome.setText(p.nome);
        imageView.setImageResource(p.foto);
        tvMassa.setText(p.massa);


        return itemView;
    }
}
