creating project:
-----------------

mvn archetype:generate -DgroupId=com.srikanth.fullstackjava -DartifactId=assignment1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

building project:
-----------------

go to directory basicMaven

Run command - 

mvn clean package

running project:
----------------

go to directory basicMaven

Run command - 

mvn exec:java -D"exec.mainClass"="com.srikanth.fullstackjava.App"

testing project:
---------------

go to directory basicMaven

Run command -

mvn test

to run a specific test class:
-----------------------------

mvn -Dtest=AppTest1 test
