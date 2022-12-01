# SmartMicroService
Repository of SmartMicroService. SmartMicroService can be build and run as follows:
<ul>
	<li>Prerequisites
		<table border="1">
			<tr>
				<th align="left">Software</th>
				<th align="left">Purpose</th>
			</tr>
			<tr>
				<td>Java 11</td>
				<td>JDK for building and running the micro service</td>
			</tr>
			<tr>
				<td>Apache Maven</td>
				<td>Required to build the project</td>
			</tr>
			<tr>
				<td>Docker Desktop</td>
				<td>Required to build and run Docker image</td>
			</tr>
		</table>
	</li>
	<li>Build the project locally
		<ul>
			<li>Clone/checkout the project.</li>
			<li>Build the project e.g. <font color="blue">mvn clean install</font></li>
		</ul>
	</li>
	<li>Run as standalone micro service
		<ul>
			<li>Run the micro service with application properties of your choice e.g. <font color="blue">java -cp SmartMicroService.jar -Dlogging.config="test/logback.xml" -Dloader.path=test/postgresql-42.5.1.jar org.springframework.boot.loader.PropertiesLauncher --spring.config.location=test/application.yml</font></li>
		</ul>
	</li>
	<li>Run on Docker
		<ul>
			<li>Build docker image : <font color="blue">docker build -t smartservice .</font></li>
			<li>While running for the first time: <font color="blue">docker run -d --name smartservice -p 9080:9080 smartservice</font></li>
			<li>Second time onward, use <font color="blue">docker start smartservice</font> and <font color="blue">docker stop smartservice</font>, to start and stop the container respectively.</li>
		</ul>
	</li>
</ul>