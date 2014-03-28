package org.rekdev.dwmd.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.rekdev.dwmd.representations.*;

import com.yammer.metrics.annotation.*;

@Path( "/" )
public class IndexResource {

    @GET
    @Produces( value = MediaType.APPLICATION_JSON )
    @Timed
    public List<Blog> index() {
        Blog b1 = new Blog( "Dropwizard Getting Started on Gradle", "https://github.com/robertkuhar/dropwiz_get_start" );
        Blog b2 = new Blog( "Dropwizard Application connecting to MongoDB", "https://github.com/robertkuhar/dropwiz_mongo_demo" );
        return Arrays.asList( b1, b2 );
    }
}
