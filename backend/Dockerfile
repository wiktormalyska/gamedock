# Use the official Gradle image with JDK 21
FROM gradle:8.10.2-jdk21 AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Copy the source code
COPY src/ src/

# Build the application
RUN ./gradlew build --no-daemon

# Use the official OpenJDK 21 runtime image
FROM openjdk:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]