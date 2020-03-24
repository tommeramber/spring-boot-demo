FROM registry.redhat.io/openjdk/openjdk-11-rhel8@sha256:1a54f6fdd858a45a92403112ed34b8673bac48f0cb9da200852b50e1bc77f586
WORKDIR /
COPY target/ .
EXPOSE 8080
ENTRYPOINT ["java", "-jar" ,"demo-0.0.1-SNAPSHOT.jar"]