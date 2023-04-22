FROM openjdk
COPY ./target/statstop-0.0.1-SNAPSHOT.jar ./
CMD ["java","-jar","statstop-0.0.1-SNAPSHOT.jar"]