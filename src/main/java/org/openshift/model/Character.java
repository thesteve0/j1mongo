package org.openshift.model;

import com.mongodb.BasicDBObject;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by spousty on 8/22/14.
 */
public class Character {

    //private HashMap allAttributes = new HashMap(18);
    private int goldpieces, HitPoints, constitution, charisma, wisdom, intelligence, strength;
    private String race = "";
    private String name = "";
    private String playerclass = "";

    public Character() {

    }

    public HashMap<String, Object> toHashMap (){
        HashMap<String, Object> theMap = new HashMap<String, Object>(18);
        theMap.put("goldpieces", goldpieces);
        theMap.put("hitpoints", HitPoints);
        theMap.put("constitution", constitution);
        theMap.put("charisma", charisma);
        theMap.put("wisdom", wisdom);
        theMap.put("intelligence", intelligence);
        theMap.put("strength", strength);
        theMap.put("race", race);
        theMap.put("name", name);
        theMap.put("playerclass", playerclass);

        return theMap;

    }

    public Character(int goldpieces, int hitpoints, int constitution, int charisma, int wisdom, int intelligence, int strength, String race, String name, String playerclass) {
        this.goldpieces = goldpieces;
        this.HitPoints = hitpoints;
        this.constitution = constitution;
        this.charisma = charisma;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.strength = strength;
        this.race = race;
        this.name = name;
        this.playerclass = playerclass;
    }

    public int getGoldpieces() {
        return goldpieces;
    }

    public void setGoldpieces(int goldpieces) {
        this.goldpieces = goldpieces;
    }

    public int getHitpoints() {
        return HitPoints;
    }

    public void setHitpoints(int hitpoints) {
        this.HitPoints = hitpoints;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerclass() {
        return playerclass;
    }

    public void setPlayerclass(String playerclass) {
        this.playerclass = playerclass;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


