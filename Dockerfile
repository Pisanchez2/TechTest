
# Use an appropriate base image for Jakarta EE with Java 17
FROM openjdk:17-jdk-alpine

# Set up application directory
WORKDIR /app

COPY target/*.jar /app/app.jar

# Expose the required port for the Jakarta EE application
EXPOSE 8080

# Use a custom entry point to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]