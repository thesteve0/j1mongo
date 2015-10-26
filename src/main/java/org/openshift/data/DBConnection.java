package org.openshift.data;

import com.mongodb.DB;
import com.mongodb.Mongo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.net.UnknownHostException;

/**
 * Created by spousty on 10/26/15.
 */

@Named
@ApplicationScoped
public class DBConnection {

    private DB mongoDB;
    private String test = "why greetings to you";


    public DBConnection() {
        super();
        System.out.println("Why am I getting no output");

    }

    @PostConstruct
    public void afterCreate() {
        System.out.println("just see if we can say anything");

        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");

        if (host == null || "".equals(host)){
            //we are not on openshift
            Mongo mongo = null;
            try {
                mongo = new Mongo( "localhost" , 27017 );
                mongoDB = mongo.getDB("javaws");
            } catch (UnknownHostException e) {
                System.out.println("Could not connect to Mongo on Localhost: " + e.getMessage());
            }


        } else {

            //on openshift
            String mongoport = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
            String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
            String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
            String db = System.getenv("OPENSHIFT_APP_NAME");
            int port = Integer.decode(mongoport);

            Mongo mongo = null;
            try {
                mongo = new Mongo(host , port);
            } catch (UnknownHostException e) {
                System.out.println("Couldn't connect to Mongo: " + e.getMessage() + " :: " + e.getClass());
            }

            mongoDB = mongo.getDB(db);

            if(mongoDB.authenticate(user, password.toCharArray()) == false) {
                System.out.println("Failed to authenticate DB ");
            }
        }





    }

    public DB getDB(){
        return mongoDB;
    }

    public String getMessage(){
        return test;
    }


}
