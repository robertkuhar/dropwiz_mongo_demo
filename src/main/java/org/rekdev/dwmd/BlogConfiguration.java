package org.rekdev.dwmd;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.*;
import com.yammer.dropwizard.config.*;

public class BlogConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    public String mongoURI = "mongodb://dwmdapp:ca!!0fDuty@bobk-mbp.local,bobk-mbp.local:27018,bobk-mbp.local:27020/dropwiz_mongo_demo";

}
