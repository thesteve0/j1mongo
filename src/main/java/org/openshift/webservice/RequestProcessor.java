package org.openshift.webservice;

import com.mongodb.*;
import org.openshift.data.DBConnection;
import org.openshift.model.Character;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by spousty on 10/26/15.
 */

@Path("/")
public class RequestProcessor {

    @Inject
    private DBConnection dbConnection;

    //get all the characters
    // TODO this needs to be secured for admins only
    @Path("admin")
    @GET()
    @Produces("application/json")
    public List getAllPlayers(){
        ArrayList allDDPeople = new ArrayList();
        DB db = dbConnection.getDB();
        DBCollection playerListCollection = db.getCollection("players");
        DBCursor cursor = playerListCollection.find();
        try {
            while(cursor.hasNext()) {

                BasicDBObject dataValue = (BasicDBObject) cursor.next();
                dataValue.put("mongoid", dataValue.getObjectId("_id").toString());
                dataValue.remove("_id");

            }
        } finally {
            cursor.close();
        }

        return allDDPeople;
    }


    //TODO this needs to work with players and a token from the j1dd service
    @POST
    @Path("players")
    @Consumes("application/json")
    @Produces("application/json")
    public HashMap insertACharacter(Character character){


        DB db = dbConnection.getDB();
        DBCollection playerListCollection = db.getCollection("players");
        BasicDBObject charDBObject = new BasicDBObject(character.toHashMap());
        try{
            playerListCollection.insert(charDBObject, WriteConcern.SAFE);
        } catch (Exception e) {
            System.out.println("threw an exception: " + e.getClass() + " :: " + e.getMessage());
        }

        //now make it look pretty
        charDBObject.put("mongoid",  charDBObject.getObjectId("_id").toString());
        charDBObject.remove("_id");
        return charDBObject;

    }
}
