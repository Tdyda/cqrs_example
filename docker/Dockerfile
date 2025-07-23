FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

COPY docker/entrypoint.sh /entrypoint.sh
COPY docker/wait-for-it.sh /wait-for-it.sh

RUN chmod +x /entrypoint.sh /wait-for-it.sh

RUN chmod +x mvnw

RUN ./mvnw clean install -DskipTests

RUN cp target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "/entrypoint.sh"]
