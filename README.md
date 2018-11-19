1) Compile using apache maven
`mvn clean install`
or IntelliJ Idea built-in maven facilities

2) Download wildfly-8.2.1 from http://download.jboss.org/wildfly/8.2.1.Final/wildfly-8.2.1.Final.zip

3) unzip wildfly-8.2.1.Final.zip

4) run wildfly-8.2.1 app server in standalone mode 
D:\Programs\wildfly-8.2.1.Final\bin\standalone.bat 

5) Copy ..\pet-project-EJB-JSF-JPA\target\pet.war into ..\wildfly-8.2.1.Final\standalone\deployments
This will initiate application deployment.
Wildly will deploy the app automatically.
After the app is deployed you will see the file pet.war.deployed alongside with pet.war

6) Navigate to http://localhost:8080/pet and have fun ))) 