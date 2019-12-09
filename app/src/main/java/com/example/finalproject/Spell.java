package com.example.finalproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Spell implements Parcelable {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCounterSpell() {
        return counterSpell;
    }

    public void setCounterSpell(String counterSpell) {
        this.counterSpell = counterSpell;
    }

    private String type, name, effect, counterSpell;

    public Spell(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeString(this.effect);
        dest.writeString(this.counterSpell);
    }

    protected Spell(Parcel in) {
        this.type = in.readString();
        this.name = in.readString();
        this.effect = in.readString();
        this.counterSpell = in.readString();
    }

    public static final Parcelable.Creator<Spell> CREATOR = new Parcelable.Creator<Spell>() {
        @Override
        public Spell createFromParcel(Parcel source) {
            return new Spell(source);
        }

        @Override
        public Spell[] newArray(int size) {
            return new Spell[size];
        }
    };
}
