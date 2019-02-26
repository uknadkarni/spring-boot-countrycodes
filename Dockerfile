FROM adoptopenjdk/openjdk8  

COPY ./target/spring-boot-phonebook-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT [ "java", "-jar", "spring-boot-phonebook-0.0.1-SNAPSHOT.jar" ]
