package com.example.mstoc.esercitazionebonus;

import java.io.Serializable;

public class Utente implements Serializable {
    private String username;
    private String password;

    public Utente() {
        this.setUsername("");
        this.setPassword("");
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
