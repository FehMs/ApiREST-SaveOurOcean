FROM openjdk:17-alpine

ARG ENVIRONMENT=prod

WORKDIR SPRING_PROFILES_ACTIVE=${ENVIRONMENT}

COPY target/SaveOurOcean-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]