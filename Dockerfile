FROM gradle:6.6.1-jdk8 AS gradle
COPY --chown=gradle:gradle . /home
WORKDIR /home
RUN gradle build --no-daemon

FROM openjdk:8-jdk-alpine AS java
EXPOSE 8080
RUN mkdir /app
COPY --from=gradle /home/build/libs/*.jar /app/boost-feature-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/boost-feature-1.0-SNAPSHOT.jar"]