FROM openjdk:11-jdk-slim

RUN apt-get update && mkdir -p /usr/share/man/man1 && mkdir -p /usr/share/man/man7 && apt-get install -y maven

COPY . hello

WORKDIR hello
RUN mvn clean install

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/hello.jar","--spring.config.location=/etc/config/application.properties"]
