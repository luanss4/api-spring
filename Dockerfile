# Use the official maven/Java 17 image to create a build artifact.
FROM maven:3.8.4-openjdk-17 as builder

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file to our app directory
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src /app/src

# Build the project
RUN mvn clean package

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-jdk-alpine

# Set the working directory in the image to /app
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]