package com.example.ispit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class PostModel2 {
    private String fullName, alterEgo, aliases, firstAppearance, publisher, aligment, gender, race, height, weigth, eyeColor, hairColor;

    public PostModel2() {
    }

    public PostModel2(String fullName, String alterEgo, String aliases, String firstAppearance, String publisher, String aligment, String gender, String race, String height, String weigth, String eyeColor, String hairColor) {
        this.fullName = fullName;
        this.alterEgo = alterEgo;
        this.aliases = aliases;
        this.firstAppearance = firstAppearance;
        this.publisher = publisher;
        this.aligment = aligment;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weigth = weigth;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAligment() {
        return aligment;
    }

    public void setAligment(String aligment) {
        this.aligment = aligment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public static PostModel2 parseJSONObject (JSONObject object) {
        PostModel2 p = new PostModel2();

        try{
            if(object.has("biography")) {
                p.setFullName(object.getJSONObject("biography").getString("full-name"));
            }
            if(object.has("biography")) {
                p.setAlterEgo(object.getJSONObject("biography").getString("alter-egos"));
            }
            if(object.has("biography")) {
                p.setAliases(object.getJSONObject("biography").getString("aliases"));
            }
            if(object.has("biography")) {
                p.setFirstAppearance(object.getJSONObject("biography").getString("first-appearance"));
            }
            if(object.has("biography")) {
                p.setPublisher(object.getJSONObject("biography").getString("publisher"));
            }
            if(object.has("biography")) {
                p.setAligment(object.getJSONObject("biography").getString("alignment"));
            }
            if(object.has("appearance")) {
                p.setGender(object.getJSONObject("appearance").getString("gender"));
            }
            if(object.has("appearance")) {
                p.setRace(object.getJSONObject("appearance").getString("race"));
            }
            if(object.has("appearance")) {
                p.setHeight(object.getJSONObject("appearance").getString("height"));
            }
            if(object.has("appearance")) {
                p.setWeigth(object.getJSONObject("appearance").getString("weight"));
            }
            if(object.has("appearance")) {
                p.setEyeColor(object.getJSONObject("appearance").getString("eye-color"));
            }
            if(object.has("appearance")) {
                p.setHairColor(object.getJSONObject("appearance").getString("hair-color"));
            }

        } catch (Exception e) {

        }
        return p;
    }
    public static LinkedList<PostModel2> parseJSONArray (JSONArray array) {
        LinkedList<PostModel2> list = new LinkedList<>();

        try {
            for (int i = 0; i < array.length(); i++){
                PostModel2 p = parseJSONObject(array.getJSONObject(i));
                list.add(p);
            }
        } catch (Exception e) {

        }

        return list;
    }
}
