package org.rekdev.dwmd;

import com.mongodb.*;
import com.yammer.metrics.core.*;

public class MongoHealthCheck extends HealthCheck {
    
    private final MongoClient mongo;

    public MongoHealthCheck( MongoClient mongo ) {
        super( MongoHealthCheck.class.getSimpleName() );
        this.mongo = mongo;
    }
    
    @Override
    protected Result check() throws Exception {
        // TODO: This HealthCheck is wholly inadequate.
        if ( mongo == null ) {
            return Result.unhealthy( "expected mongo not null" );
        }
        if ( mongo.getReplicaSetStatus().getMaster() == null ) {
            return Result.unhealthy( "mongo has no PRIMARY" );
        }
        return Result.healthy();
    }

}
