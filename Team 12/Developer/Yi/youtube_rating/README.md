We use java and spring boot to set up a server
To run the server locally run "mvn spring-boot:run" under the folder of /Developer/Yi/youtube_rating
Be sure you install the following:
1. Java 
2. Spring-boot
3. Mysql Server

Set you table name in sql in application.properties
Like spring.datasource.url=jdbc:mysql://localhost:3306/ratings?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC