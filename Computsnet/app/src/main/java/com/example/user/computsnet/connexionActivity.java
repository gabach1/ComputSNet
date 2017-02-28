package com.example.user.computsnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnexionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button sIN = (Button) findViewById(R.id.sign_In);
        Button sUP = (Button) findViewById(R.id.sign_Up);

        sIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSin = new Intent(ConnexionActivity.this, Authentification.class);
                startActivity(versSin);
            }
        });

        sUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versSup = new Intent(ConnexionActivity.this, Inscription.class);
                startActivity(versSup);
            }
        });
    }
}