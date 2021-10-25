FROM openjdk:15
EXPOSE 8050
ADD /target/orders-0.0.1-SNAPSHOT.jar orders.jar
ENTRYPOINT ["java","-jar","orders.jar"]