FROM openjdk:8-jre-alpine
COPY build/libs/calculator-add.jar calculator-add.jar 
WORKDIR .
EXPOSE 8888
CMD ["java", "-jar", "calculator-add.jar"]
