FROM openjdk:17
EXPOSE 6061
COPY target/api-gateway-service-0.0.1-SNAPSHOT.jar api-gateway-service.jar
ENV SPRING_PROFILES_ACTIVE=dev
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-Xmx256m", "-jar","api-gateway-service.jar"]