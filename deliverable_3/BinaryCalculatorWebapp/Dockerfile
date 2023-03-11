FROM eclipse-temurin:17-jdk-alpine

WORKDIR /binary-calculator

COPY target/Webapp.war ./Webapp.war

ENTRYPOINT ["java", "-jar", "Webapp.war"]
