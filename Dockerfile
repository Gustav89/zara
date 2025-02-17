FROM eclipse-temurin:21

LABEL author=Gustavo.Matias.Alvarez

COPY target/zara-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]