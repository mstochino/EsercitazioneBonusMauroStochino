package com.example.mstoc.esercitazionebonus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class Risultati extends AppCompatActivity {

    Utente utente;
    TextView username;
    Button indietro;
    private boolean accesso;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultati);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Login.UTENTE_EXTRA);
        FactoryUtenti factory = FactoryUtenti.getInstance();

        if (obj instanceof Utente)
            utente = (Utente) obj;
        else
            utente = new Utente();

        username = (TextView) findViewById(R.id.username);
        indietro = (Button) findViewById(R.id.indietro);

        for (Utente utenteRegistrato : factory.getListaUtenti()) {
            if (utente.getUsername().equals(utenteRegistrato.getUsername()) && utente.getPassword().equals(utenteRegistrato.getPassword())) {
                accesso = true;
                break;
            }
            else
                accesso = false;
        }

        if (accesso)
            username.setText("Benvenuto " + utente.getUsername());
        else
            username.setText("Accesso negato");

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(Risultati.this, com.example.mstoc.esercitazionebonus.Login.class);
                startActivity(goBack);
            }
        });
    }
}
