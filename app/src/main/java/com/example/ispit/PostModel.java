package com.example.ispit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class PostModel {
    private String name, intelligence, strength, speed, durability, power, combat, image;

    public PostModel() {
    }

    public PostModel(String name, String intelligence, String strength, String speed, String durability, String power, String combat, String image) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static PostModel parseJSONObject (JSONObject object) {
        PostModel post = new PostModel();

       try{
            if(object.has("name")) {
                post.setName(object.getString("name"));
            }
            if(object.has("powerstats")){
                post.setIntelligence(object.getJSONObject("powerstats").getString("intelligence"));
            }
           if(object.has("powerstats")){
               post.setStrength(object.getJSONObject("powerstats").getString("strength"));
           }
           if(object.has("powerstats")){
               post.setSpeed(object.getJSONObject("powerstats").getString("speed"));
           }
           if(object.has("powerstats")){
               post.setDurability(object.getJSONObject("powerstats").getString("durability"));
           }
           if(object.has("powerstats")) {
               post.setPower(object.getJSONObject("powerstats").getString("power"));
           }
           if(object.has("powerstats")){
               post.setCombat(object.getJSONObject("powerstats").getString("combat"));
           }
           if(object.has("image")){
               post.setImage(object.getJSONObject("image").getString("url"));
           }

        } catch (Exception e) {

        }


        return post;
    }

    public static LinkedList<PostModel> parseJSONArray (JSONArray array) {
        LinkedList<PostModel> list = new LinkedList<>();

        try {
            for (int i = 0; i < array.length(); i++){
                PostModel post = parseJSONObject(array.getJSONObject(i));
                list.add(post);
            }
        } catch (Exception e) {

        }

        return list;
    }
}
