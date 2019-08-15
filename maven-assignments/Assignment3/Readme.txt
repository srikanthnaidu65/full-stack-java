1. Open eclipe and create new maven project.

2. Open pom.xml and add/modify the below dependencies

	<properties>
		<junit.version>3.8.1</junit.version>
		<apache.version>3.0</apache.version>
		<mysql-version>5.1.35</mysql-version>
	</properties>

 		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>${apache.version}</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysql-version}</version>
		</dependency>

	<build>
		<finalName>srikanth</finalName>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
				<version>2.4.3</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
							<transformers>
								<transformer
									implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
									<manifestEntries>
										<Main-Class>com.srikanth.fullstackjava.App</Main-Class>
										<Build-Number>1.0</Build-Number>
									</manifestEntries>
								</transformer>
							</transformers>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>


3. Build project:

Open terminal and got to directory srikanth and run the command

mvn clean package

4. Running project:

go to directory srikanth and run command

mvn exec:java -D"exec.mainClass"="com.srikanth.fullstackjava.App"

5. Testing project:

go to directory srikanth and run command

mvn test

