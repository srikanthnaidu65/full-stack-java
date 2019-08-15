1. Creating webapp:

From command line: mvn archetype:generate -DgroupId=com.srikanth.fullstackjava -DartifactId=assignment4 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

(or)

From Eclipse: Create new maven project: New->MavenProject-> select artidfactID and other details->finish

2. Building App:

go to directory srikanth1 and run the command

mvn clean package


3. Host on server:

Copy the war file to tomcat deploy directory and start the server
