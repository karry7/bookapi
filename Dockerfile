FROM openjdk:17
EXPOSE 8080
ADD target/springbootbookapi.jar springbootbookapi.jar
ENTRYPOINT ["java","-jar","/springbootbookapi.jar"]
