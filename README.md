dropwiz_mongo_demo
=================

Dropwizard Application connecting to MongoDB

This project implements a Dropwizard application to interact with MongoDB and is an adaption of https://www.openshift.com/blogs/day-13-dropwizard-the-awesome-java-rest-server-stack to gradle.

Following the gradle build, the product can be executed from the command line like

java -jar build/libs/dropwiz_mongo_demo-1.0.0.jar server src/main/resources/dropwiz_mongo_demo.yml

With the server running requests are like http://localhost:8080/

Check out the Monitoring interface at http://localhost:8081/

TODO:  The MongoHealthCheck leaves much to be desired
TODO:  The MongoManaged thing should, probably, expose its MongoClient
TODO:  Logging, logging, logging.  How does logging work.
TODO:  How do you gracefully shutdown when running out of Eclipse?


