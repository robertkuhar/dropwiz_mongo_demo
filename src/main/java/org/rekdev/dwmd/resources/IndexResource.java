package org.rekdev.dwmd.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.mongojack.*;
import org.rekdev.dwmd.representations.*;

import com.yammer.metrics.annotation.*;

@Path( "/" )
public class IndexResource {

    private JacksonDBCollection<Blog, String> collection;

    public IndexResource( JacksonDBCollection<Blog, String> blogs ) {
        this.collection = blogs;
    }

    @GET
    @Produces( value = MediaType.APPLICATION_JSON )
    @Timed
    public List<Blog> index() {
        DBCursor<Blog> dbCursor = collection.find();
        List<Blog> blogs = new ArrayList<>();
        while ( dbCursor.hasNext() ) {
            Blog blog = dbCursor.next();
            blogs.add( blog );
        }
        return blogs;
    }
}
