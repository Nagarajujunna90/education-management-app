FROM amazoncorretto:17
COPY target/auth-service-0.0.1-SNAPSHOT.jar auth-service.jar
EXPOSE 6062
ENV SPRING_PROFILES_ACTIVE=dev
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-Xmx256m", "-jar", "auth-service.jar"]
