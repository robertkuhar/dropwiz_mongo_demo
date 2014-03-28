package org.rekdev.dwmd.resources;

import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

import org.mongojack.*;
import org.rekdev.dwmd.representations.*;

import com.yammer.metrics.annotation.*;

@Path( "/blogs" )
@Produces( value = MediaType.APPLICATION_JSON )
@Consumes( value = MediaType.APPLICATION_JSON )
public class BlogResource {

    private JacksonDBCollection<Blog, String> collection;

    public BlogResource( JacksonDBCollection<Blog, String> blogs ) {
        this.collection = blogs;
    }

    @POST
    @Timed
    public Response publishNewBlog( @Valid Blog blog ) {
        collection.insert( blog );
        return Response.noContent().build();
    }
}
