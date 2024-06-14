FROM gradle:jdk21 AS build

WORKDIR /app

COPY build.gradle.kts /app/
COPY settings.gradle.kts /app/
COPY gradle.properties /app/
COPY src /app/src
COPY gradlew /app/
COPY gradlew.bat /app/
COPY gradle /app/gradle

RUN ./gradlew build

FROM openjdk:21

WORKDIR /app

COPY --from=build /app/build/libs/library-all.jar /app/app.jar

EXPOSE 5555

CMD ["java", "-jar", "app.jar"]
