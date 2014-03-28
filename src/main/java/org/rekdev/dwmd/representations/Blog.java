package org.rekdev.dwmd.representations;

import java.util.*;

import org.hibernate.validator.constraints.*;
import org.mongojack.*;

public class Blog {

    @Id
    @ObjectId
    private String id;

    @NotBlank
    private String title;

    @URL
    @NotBlank
    private String url;
    
    private final Date publishedOn = new Date();

    public Blog() {
    }

    public Blog(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }
}
