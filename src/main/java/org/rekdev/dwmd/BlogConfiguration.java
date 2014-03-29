package org.rekdev.dwmd;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.*;
import com.yammer.dropwizard.config.*;

public class BlogConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    public String mongoURI = "mongodb://localhost";

}
