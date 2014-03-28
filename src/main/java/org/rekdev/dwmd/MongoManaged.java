package org.rekdev.dwmd;

import com.mongodb.*;
import com.yammer.dropwizard.lifecycle.*;

public class MongoManaged implements Managed {

    private final MongoClient mongo;

    public MongoManaged( MongoClient mongo ) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        if ( mongo != null ) {
            mongo.close();
        }
    }

}
