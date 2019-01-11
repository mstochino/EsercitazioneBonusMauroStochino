package com.example.mstoc.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button accedi;
    Utente utente = new Utente();

    public static final String UTENTE_EXTRA = "com.example.mstoc.esercitazionebonus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        accedi =  (Button) findViewById(R.id.accedi);

        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()){
                    updateUtente();

                    Intent mostraRisultati = new Intent(Login.this, com.example.mstoc.esercitazionebonus.Risultati.class);
                    mostraRisultati.putExtra(UTENTE_EXTRA, utente);
                    startActivity(mostraRisultati);
                }
            }
        });
    }

    public void updateUtente(){
        utente.setUsername(""+username.getText());
        utente.setPassword(""+password.getText());
    }

    private boolean checkInput(){
        int errori = 0;

        if (username.getText() == null || username.getText().length() == 0) {
            username.setError("Inserisci il tuo username");
            errori++;
        }
        else
            username.setError(null);

        if (password.getText() == null || password.getText().length() == 0) {
            password.setError("Inserisci la password");
            errori++;
        }
        else
            password.setError(null);

        return errori ==  0;
    }
}
