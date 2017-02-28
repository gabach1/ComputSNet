package com.gabach.bddprojetgood.bddprojetgood;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/**
 * Created by gqbqch on 24/02/2017.
 */

public class Membres implements Parcelable{
    private long id = 1;
    private String pseudo = "Inconnu";
    private String mdpasse = "Inconnu";

    public Membres() {}

    public Membres(JSONObject jObject) {
        this.id = jObject.optLong("id");
        this.pseudo = jObject.optString("pseudo");
        this.mdpasse = jObject.optString("mdpasse");
    }

    public long getId(){

        return id;
    }

    public String getNom(){

        return pseudo;
    }

    public String getPasse(){

        return mdpasse;
    }

    public void setId(long a){

        this.id = a;
    }

    public void setNom(String b){

        this.pseudo = b;
    }

    public void setPasse(String c){

        this.mdpasse = c;
    }

    public int describeContents()
    {
        return 0;
    }

    public Membres(Parcel in) {
        this.id = in.readLong();
        this.pseudo = in.readString();
        this.mdpasse = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeLong(id);
        dest.writeString(pseudo);
        dest.writeString(mdpasse);
    }

    public static final Parcelable.Creator<Membres> CREATOR = new Parcelable.Creator<Membres>()
    {
        @Override
        public Membres createFromParcel(Parcel source)
        {
            return new Membres(source);
        }

        @Override
        public Membres[] newArray(int size)
        {
            return new Membres[size];
        }
    };
}