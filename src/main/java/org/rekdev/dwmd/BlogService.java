package org.rekdev.dwmd;

import java.net.*;

import org.mongojack.*;
import org.rekdev.dwmd.representations.*;
import org.rekdev.dwmd.resources.*;

import com.mongodb.*;
import com.yammer.dropwizard.*;
import com.yammer.dropwizard.config.*;

public class BlogService extends Service<BlogConfiguration> {

    public static void main( String[] args ) throws Exception {
        new BlogService().run( new String[] { "server" } );
    }

    @Override
    public void initialize( Bootstrap<BlogConfiguration> bootstrap ) {
        bootstrap.setName( "blog" );
    }

    @Override
    public void run( BlogConfiguration configuration, Environment environment ) throws Exception {
        MongoClient mongo = makeMongoClient( configuration.mongoURI );
        DB db = mongo.getDB( "dropwiz_mongo_demo" );

        JacksonDBCollection<Blog, String> blogs = JacksonDBCollection
                .wrap( db.getCollection( "blogs" ), Blog.class, String.class );

        MongoManaged mongoManaged = new MongoManaged( mongo );
        environment.manage( mongoManaged );
        environment.addHealthCheck( new MongoHealthCheck( mongo ) );
        environment.addResource( new IndexResource( blogs ) );
        environment.addResource( new BlogResource( blogs ) );
    }

    private MongoClient makeMongoClient( String mongoURI ) throws UnknownHostException {
        MongoClientURI clientURI = new MongoClientURI( mongoURI );
        MongoClient client = new MongoClient( clientURI );
        return client;
    }
}
