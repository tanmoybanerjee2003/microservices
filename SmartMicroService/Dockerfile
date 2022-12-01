FROM adoptopenjdk/openjdk11:alpine-slim

COPY target/SmartMicroService.jar app.jar
COPY test/application-docker.yml application.yml
COPY test/logback.xml logback.xml
COPY test/postgresql-42.5.1.jar postgresql.jar

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/urandom", "-cp", "app.jar", "-Dlogging.config=logback.xml", "-Dloader.path=postgresql.jar", "org.springframework.boot.loader.PropertiesLauncher", "--spring.config.location=application.yml"]