FROM registry.redhat.io/openjdk/openjdk-11-rhel8
WORKDIR /
COPY target/ .
EXPOSE 8080
ENTRYPOINT ["java", "-jar" ,"demo-0.0.1-SNAPSHOT.jar"]