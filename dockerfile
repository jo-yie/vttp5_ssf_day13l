# base image with JDK
# used to build and run the Java application
FROM maven:3-eclipse-temurin-23

# labeling the dockerfile (not mandatory)
LABEL MAINTAINER="jo yie"
LABEL description="This is VTTP5 Day 13 Lecture Demo + Day 14 Docker Demo"
LABEL name="vttp5_ssf_day13l"

# specify directory
ARG APP_DIR=/APP

# directory where source code resides
# directory where we copy our project to (in the next step)
WORKDIR ${APP_DIR}

# copy the required files and/or directories into the image
COPY pom.xml .
COPY mvnw .
COPY src src
COPY .mvn .mvn

# package the application using the RUN directive 
# this will download the dependencies defined in pom.xml 
# compile and package to JAR 
RUN mvn package -Dmaven.test.skip=true

# defining an environment variable 
ENV SERVER_PORT=3000

# expose port 
EXPOSE ${SERVER_PORT}

# specify entry point 
ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp5_ssf_day13l-0.0.1-SNAPSHOT.jar