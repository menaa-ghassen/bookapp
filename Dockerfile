FROM java:8
EXPOSE 8080
COPY target/bookapp-0.0.1-SNAPSHOT.jar bookapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bookapp-0.0.1-SNAPSHOT.jar"]