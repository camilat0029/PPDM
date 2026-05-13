package com.example.meuapp;

import java.util.ArrayList;

public class PlanetaDAO {

    ArrayList<Planeta> listaPlanetas;
    public PlanetaDAO() {
        listaPlanetas=new ArrayList<>();
        listaPlanetas.add(new Planeta("Mercúrio",  R.drawable.mercury, "3,3011×10^23"));
        listaPlanetas.add(new Planeta("Vênus", R.drawable.venus, "4,86 x 10^24"));
        listaPlanetas.add(new Planeta("Terra", R.drawable.earth, "5,972 × 10^24"));
        listaPlanetas.add(new Planeta("Marte", R.drawable.mars, "6,39 × 10^23"));
        listaPlanetas.add(new Planeta("Júpiter", R.drawable.jupter, "1,898 × 10^27"));
        listaPlanetas.add(new Planeta("Saturno", R.drawable.saturn, "5,6834×10^26"));
        listaPlanetas.add(new Planeta("Urano", R.drawable.uranus, "8,681 × 10^25"));
        listaPlanetas.add(new Planeta("Netuno", R.drawable.neptune, "1,024 × 10^26"));
    }

    public ArrayList<Planeta> listaPlanetas(){
        return listaPlanetas;
    }


}
