FROM alpine:latest
COPY pom.xml /tmp
COPY src /tmp/src
WORKDIR /tmp
RUN apk update && \
    apk add openjdk21 \
            maven && \
    mvn package