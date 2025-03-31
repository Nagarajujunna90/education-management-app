FROM openjdk:17
EXPOSE 6063
COPY target/admin-service-0.0.1-SNAPSHOT.jar admin-service.jar
ENV SPRING_PROFILES_ACTIVE=dev
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-Xmx256m", "-jar","admin-service.jar"]