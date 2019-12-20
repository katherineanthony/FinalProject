package com.example.finalproject;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Charecter implements Parcelable {
    private String house, name, patronus, desc, bloodStatus, wand, image;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public void setBloodStatus(String bloodStatus) {
        this.bloodStatus = bloodStatus;
    }

    public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.house);
        dest.writeString(this.name);
        dest.writeString(this.patronus);
        dest.writeString(this.desc);
        dest.writeString(this.bloodStatus);
        dest.writeString(this.wand);
        dest.writeString(this.image);
    }

    public Charecter() {
    }

    protected Charecter(Parcel in) {
        this.house = in.readString();
        this.name = in.readString();
        this.patronus = in.readString();
        this.desc = in.readString();
        this.bloodStatus = in.readString();
        this.wand = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Charecter> CREATOR = new Parcelable.Creator<Charecter>() {
        @Override
        public Charecter createFromParcel(Parcel source) {
            return new Charecter(source);
        }

        @Override
        public Charecter[] newArray(int size) {
            return new Charecter[size];
        }
    };
}
