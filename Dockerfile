#==Version==#
FROM eclipse-temurin:17

#==Meta Data==#
LABEL mentainer = "yibaben@gmail.com"

#==Working Directory==#
WORKDIR /app

#==Copy Source File to a destination in Container==#
COPY target/Spring-Boot-Rest-API-0.0.1-SNAPSHOT.jar /app/spring-boot-rest-api.jar

#==EntryPoint command to run the jar file==#
ENTRYPOINT["java", "-jar", "spring-boot-rest-api.jar"]