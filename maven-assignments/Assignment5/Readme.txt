1. Creating webapp:

From command line: mvn archetype:generate -DgroupId=com.srikanth.fullstackjava -DartifactId=assignment5 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

(or)

From Eclipse: Create new maven project: New->MavenProject-> select artidfactID and other details->finish

2. Create 2 profies in pom.xml:

  <profiles>
      <profile>
         <id>dev</id>
         <build>
            <plugins>
               <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-antrun-plugin</artifactId>
                  <version>1.1</version>
                  <executions>
                     <execution>
                        <phase>test</phase>
                        <goals>
                           <goal>run</goal>
                        </goals>
                        <configuration>
                           <tasks>
                              <echo>Using dev myapp properites</echo>
                              <copy file="src/main/env/dev_webapp/myapp.properties"
                                 tofile="${project.build.outputDirectory}
                                 /myapp.properties"/>
                           </tasks>
                        </configuration>
                     </execution>
                  </executions>
               </plugin>
            </plugins>
         </build>
      </profile>
      <profile>
         <id>itg</id>
         <build>
            <plugins>
               <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-antrun-plugin</artifactId>
                  <version>1.1</version>
                  <executions>
                     <execution>
                        <phase>test</phase>
                        <goals>
                           <goal>run</goal>
                        </goals>
                        <configuration>
                           <tasks>
                              <echo>Using itg myapp properites</echo>
                              <copy file="src/main/env/itg_webapp/myapp.properties"
                                 tofile="${project.build.outputDirectory}
                                 /myapp.properties"/>
                           </tasks>
                        </configuration>
                     </execution>
                  </executions>
               </plugin>
            </plugins>
         </build>
      </profile>
   </profiles>

3. Build the project:

go to directory srikanth2 and run the command

mvn test -Pdev

mvn test -Pitg


3. Host on server:

Copy the war file to tomcat deploy directory and start the server
