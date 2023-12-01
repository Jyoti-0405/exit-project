# Use an official Maven image with Java 17 as a base image
FROM maven:3.6.3-openjdk-17-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven POM file
COPY pom.xml .

# Download the dependencies and build the application
RUN mvn clean install -DskipTests

# Copy the application code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use an official OpenJDK runtime image with Java 17 as a base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage to the runtime image
COPY --from=builder /app/target/productCommunity-0.0.1-SNAPSHOT.jar ./app.jar

# Set the command to run your application
CMD ["java", "-jar", "app.jar"]


