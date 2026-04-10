# Stage 1 : build
FROM eclipse-temurin:11-jdk AS build
WORKDIR /app
COPY . .
RUN sed -i 's/\r//' gradlew && chmod +x gradlew && ./gradlew bootJar --no-daemon

# Stage 2 : run
FROM eclipse-temurin:11-jre
VOLUME /tmp
EXPOSE 8080
COPY --from=build /app/build/libs/Hello-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
