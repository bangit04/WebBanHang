FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} backend-service.jar

LABEL authors="bangi"

ENTRYPOINT ["java", "-jar", "WebBanHang.jar"]

EXPOSE 8080