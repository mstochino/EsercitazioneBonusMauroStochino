package com.example.mstoc.esercitazionebonus;

import java.util.ArrayList;

public class FactoryUtenti {
    private static FactoryUtenti instance;
    private ArrayList<Utente> listaUtenti = new ArrayList<>();

    private FactoryUtenti(){
        Utente utente1 = new Utente();
        utente1.setUsername("Mauro");
        utente1.setPassword("permitgranted");

        Utente utente2 = new Utente();
        utente2.setUsername("admin");
        utente2.setPassword("admin");

        Utente utente3 = new Utente();
        utente3.setUsername("Ines");
        utente3.setPassword("adelante");

        Utente utente4 = new Utente();
        utente4.setUsername("Gyganti");
        utente4.setPassword("excalibur");

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
    }

    public static FactoryUtenti getInstance(){
        if (instance == null)
            instance = new FactoryUtenti();

        return instance;
    }

    public ArrayList<Utente> getListaUtenti(){
        return listaUtenti;
    }
}
