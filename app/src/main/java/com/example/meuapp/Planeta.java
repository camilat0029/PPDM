package com.example.meuapp;

import android.graphics.Bitmap;

public class Planeta {

    String nome;
    String massa;
    int foto;

    public Planeta(String nome, int foto, String massa) {
        this.nome = nome;
        this.foto = foto;
        this.massa = massa;
    }
}

    ///Exemplo de como criaria um objeto desta classe

    ///Planeta p = new Planeta();
    ///p.nome="Terra"
    ///p.foto=R.drawable.earth;