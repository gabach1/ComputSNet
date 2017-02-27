package com.example.user.computsnet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gabach.bddprojetgood.bddprojetgood.HttpCall;
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

public class Inscription extends Activity {
    private List<Membres> maliste = new ArrayList<Membres>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insc);

        final Context context = getApplicationContext();
        final Button submitUp = (Button) findViewById(R.id.sign_Up);
        final EditText pseudo = (EditText) findViewById(R.id.pseudo_signUp);
        final EditText mdpasse = (EditText) findViewById(R.id.mdpasse_signUp);
        final EditText confMdpasse = (EditText) findViewById(R.id.confirm_mdpasse_signUp);

        submitUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "Entrer";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                /*
                HttpCall httpPost = new HttpCall();
                httpPost.setMethodtype(HttpCall.POST);
                httpPost.setUrl("http://www.ngassociation.com/android/comptsnet/ins.php");
                HashMap<String,String> params = new HashMap<>();
                params.put("pseudo",pseudo.getText().toString());
                params.put("mdpasse",mdpasse.getText().toString());
                httpPost.setParams(params);

                if(confMdpasse.getText().toString().equals(mdpasse.getText().toString())){
                    new HttpRequest(){
                        @Override
                        public void onResponse(String response) {
                            super.onResponse(response);

                            maliste = parse(response);

                            if(maliste.get(0).getNom().equals("true")){
                                Intent mon_intent = new Intent(Authentification.this, Home.class);
                                startActivity(mon_intent);
                                //Context context = getApplicationContext();
                                CharSequence text = "L'inscription s'est terminé correctement";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                            else{
                                //Context context = getApplicationContext();
                                CharSequence text = "Probleme lors de l'inscription";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, response, duration);
                                toast.show();
                            }
                        }
                    }.execute(httpCallPost);
                }
                else{
                    //Context context = getApplicationContext();
                    CharSequence text = "Vérifier que les mot de passe sont identiques";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                */
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
