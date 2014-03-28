package org.rekdev.dwmd;

import org.rekdev.dwmd.resources.*;

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
        environment.addResource( new IndexResource() );
    }
}
