from openjdk:22
copy ./target/demo1-0.0.1-SNAPSHOT.jar demoapp.jar
entrypoint ["java", "-jar", "demoapp.jar"]