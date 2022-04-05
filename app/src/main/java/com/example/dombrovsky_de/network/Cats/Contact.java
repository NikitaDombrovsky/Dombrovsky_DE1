package com.example.dombrovsky_de.network.Cats;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contact {
    @SerializedName("modile")
    private String modile;

    @SerializedName("email")
    private String email;

    @SerializedName("skype")
    private String skype;

    public String getModile() {
        return modile;
    }

    public void setModile(String modile) {
        this.modile = modile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
