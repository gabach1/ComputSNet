package com.example.user.computsnet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gabach.bddprojetgood.bddprojetgood.HttpCall;
import com.gabach.bddprojetgood.bddprojetgood.HttpRequest;
import com.gabach.bddprojetgood.bddprojetgood.Membres;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by gqbqch on 26/02/2017.
 */

public class Authentification extends Activity {


    private List<Membres> maliste = new ArrayList<Membres>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);

        final Button submitIn = (Button) findViewById(R.id.submit_signIn);
        final EditText pseudo = (EditText) findViewById(R.id.pseudo_signIn);
        final EditText mdpasse = (EditText) findViewById(R.id.mdpasse_signIn);

        submitIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pseudo.getText().toString().length() > 0 && mdpasse.getText().toString().length() > 0){
                    HttpCall httpCallPost = new HttpCall();
                    httpCallPost.setMethodtype(HttpCall.POST);
                    httpCallPost.setUrl("http://www.ngassociation.com/android/comptsnet/authentification.php");
                    HashMap<String,String> paramsPost = new HashMap<>();
                    paramsPost.put("pseudo",pseudo.getText().toString());
                    paramsPost.put("mdpasse",mdpasse.getText().toString());
                    httpCallPost.setParams(paramsPost);
                    new HttpRequest(){
                        @Override
                        public void onResponse(String response) {
                            super.onResponse(response);

                            maliste = parse(response);

                            if(maliste.get(0).getNom().equals(pseudo.getText().toString()))// && maliste.get(0).getPasse().equals(mdpasse.getText().toString())
                            {
                                Intent mon_intent = new Intent(Authentification.this, Home.class);
                                startActivity(mon_intent);
                            }
                            else{
                                Context context = getApplicationContext();
                                CharSequence text = "Les donnees entrées ne sont pas correct";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        }
                    }.execute(httpCallPost);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Les champs sont vides";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    public List<Membres> parse(final String json) {
        final List<Membres> Mem = new ArrayList<>();
        try {
            final JSONArray jMembresArray = new JSONArray(json);
            for (int i = 0; i < jMembresArray.length(); i++) {
                Mem.add(new Membres(jMembresArray.optJSONObject(i)));
            }
            return Mem;
        } catch (JSONException e) {
            Log.v(TAG, "[JSONException] e : " + e.getMessage());
        }
        Mem.add(new Membres());
        return Mem;
    }
}
