package com.example.meuapp;

import java.util.ArrayList;

public class PlanetaController {

    PlanetaDAO planetaDAO;
    public PlanetaController() {

        planetaDAO=new PlanetaDAO();

    }

    public ArrayList<Planeta> listaPlanetas(){

        return planetaDAO.listaPlanetas;
    }



}
