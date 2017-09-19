FROM java:8

ADD target/gs-rest-service-0.1.0.jar /gs-rest-service-0.1.0.jar
CMD java -Dserver.port=8095 -jar /gs-rest-service-0.1.0.jar
