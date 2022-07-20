FROM openjdk:8-jdk-alpine
COPY insertDB-0.0.1-SNAPSHOT.jar insertDB-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/insertDB-0.0.1-SNAPSHOT.jar"]