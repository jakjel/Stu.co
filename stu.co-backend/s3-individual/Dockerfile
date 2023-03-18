#FROM azul/zulu-openjdk-alpine:17
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#COPY build/libs/s3-individual-0.0.1-SNAPSHOT.jar s3-individual-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM azul/zulu-openjdk-alpine:17
##ARG JAR_FILE=build/libs/*.jar
##COPY ${JAR_FILE} app.jar
#COPY build/libs/s3-individual-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM amazoncorretto:17-al2-jdk
COPY build/libs/s3-individual-0.0.1-SNAPSHOT.jar s3-individual-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/s3-individual-0.0.1-SNAPSHOT.jar"]
