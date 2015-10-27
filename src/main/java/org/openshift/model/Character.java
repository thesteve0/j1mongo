package org.openshift.model;

import com.mongodb.BasicDBObject;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by spousty on 8/22/14.
 */
public class Character extends BasicDBObject {

    private HashMap allAttributes = new HashMap(18);

    private final int MAX_GOLD = 200;
    private final int MAX_HIT = 9;


    public Character() {

    }

    public Character(HashMap allAttributes) {
        this.allAttributes = allAttributes;
    }


    public HashMap getAllAttributes() {
        return allAttributes;
    }

    public void setName(String name) {
        allAttributes.put("Name", name);
    }

    public void setAllAttributes(HashMap allAttributes) {
        this.allAttributes = allAttributes;
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


