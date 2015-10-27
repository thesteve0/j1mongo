package org.openshift.webservice;

import com.mongodb.*;
import org.openshift.data.DBConnection;
import org.openshift.model.*;
import org.openshift.model.Character;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by spousty on 10/26/15.
 */

@Path("/players")
public class RequestProcessor {

    @Inject
    private DBConnection dbConnection;

    //get all the characters
    // TODO this needs to be secured for admins only
    @GET()
    @Produces("application/json")
    public List getAllPlayers(){
        ArrayList allDDPeople = new ArrayList();
        DB db = dbConnection.getDB();
        DBCollection playerListCollection = db.getCollection("players");
        DBCursor cursor = playerListCollection.find();
        try {
            while(cursor.hasNext()) {

                //@Todo
                DBObject dataValue = cursor.next();

                /*HashMap holder = new HashMap<String, Object>();
                holder.put("name",dataValue.get("Name"));
                holder.put("position", dataValue.get("pos"));
                holder.put("id", dataValue.get("_id").toString());*/
                allDDPeople.add(dataValue);

            }
        } finally {
            cursor.close();
        }

        return allDDPeople;
    }


    //TODO this needs to work with players and a token from the j1dd service
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public HashMap insertACharacter(Character character){

        // TODO

        //BasicDBObject parkObject = new BasicDBObject("Name",park.getName());
        //parkObject.append("pos", park.getPos());

        DB db = dbConnection.getDB();
        DBCollection playerListCollection = db.getCollection("players");
        BasicDBObject charDBObject = new BasicDBObject(character.toHashMap());
        try{
            playerListCollection.insert(charDBObject, WriteConcern.SAFE);
        } catch (Exception e) {
            System.out.println("threw an exception: " + e.getClass() + " :: " + e.getMessage());
        }

        //now make it look pretty
        //HashMap holder = charDBObject.get;
        charDBObject.put("mongoid",  charDBObject.getObjectId("_id").toString());
        charDBObject.remove("_id");
        return charDBObject;

    }
}
