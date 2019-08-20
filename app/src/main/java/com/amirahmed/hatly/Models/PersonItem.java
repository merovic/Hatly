package com.amirahmed.hatly.Models;

public class PersonItem {

    int personImage;
    String personName;
    String personDistance;
    String personOffer;

    public PersonItem(int personImage, String personName, String personDistance, String personOffer) {
        this.personImage = personImage;
        this.personName = personName;
        this.personDistance = personDistance;
        this.personOffer = personOffer;
    }


    public int getPersonImage() {
        return personImage;
    }

    public void setPersonImage(int personImage) {
        this.personImage = personImage;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonDistance() {
        return personDistance;
    }

    public void setPersonDistance(String personDistance) {
        this.personDistance = personDistance;
    }

    public String getPersonOffer() {
        return personOffer;
    }

    public void setPersonOffer(String personOffer) {
        this.personOffer = personOffer;
    }
}
