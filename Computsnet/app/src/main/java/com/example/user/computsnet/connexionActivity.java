package com.example.user.computsnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button sIN = (Button) findViewById(R.id.sign_In);
        Button sUp = (Button) findViewById(R.id.sign_Up);

        sIN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent versIns = new Intent(ConnexionActivity.this, Authentification.class);
                startActivity(versIns);
            }
        });

        sUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent versAuth = new Intent(ConnexionActivity.this, Inscription.class);
                startActivity(versAuth);
            }
        });
    }
}
