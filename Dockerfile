# Use an official OpenJDK 21 as a base image
FROM openjdk:21-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the application source code into the container
COPY . .

# Run necessary commands to build the application
RUN apt-get update && apt-get install -y \
    && ./gradlew bootJar --no-daemon

# Create a new stage for the runtime image
FROM openjdk:21-jdk-slim

# Set the working directory in the runtime container
WORKDIR /app

# Expose the port the app runs on
EXPOSE 8080

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/build/libs/crazy_meet-1.jar app.jar

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "app.jar"]
