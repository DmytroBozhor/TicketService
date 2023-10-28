FROM openjdk:17

WORKDIR /app

COPY ./target/TicketService-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "TicketService-0.0.1-SNAPSHOT.jar"]