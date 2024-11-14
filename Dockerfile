FROM alpine:latest
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN apk update && \
    apk add openjdk17 \
            maven && \
    mvn clean package
# WORKDIR /app
  
EXPOSE 8080
CMD ["java","-jar","/app/target/flashware.jar"]
