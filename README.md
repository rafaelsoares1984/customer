# Customer
This repository is part of a test for a company, it contains a REST app.

Simple CRUD application of customer. 

Application developed by Rafael Soares.

##  URL of project

    This app has some URLs
    
  - **Service - API** [http://localhost:8080/api/customer]  
  - **Swagger - Documentation of API** [http://localhost:8080/swagger-ui.html] 
  - **H2 - Database** [http://localhost:8080/h2] 

# Functionalities of application endpoints

   Some Endpoints:

  - **GET** [http://localhost:8080/api/customer] - List all customers<br>
     `curl -X GET \`<br>
        `http://localhost:8080/api/customer/ \`<br>
        `-H 'Postman-Token: 0483fb3a-d9db-4f17-98a5-d2c3cc2987fa' \`<br>
        `-H 'cache-control: no-cache'`<br>

  - **GET** [http://localhost:8080/api/customer/`{cusmoterId}`] - Get a specific customer<br>
     `curl -X GET \`<br>
        `http://localhost:8080/api/customer/1 \`<br>
        `-H 'Postman-Token: 0483fb3a-d9db-4f17-98a5-d2c3cc2987fa' \`<br>
        `-H 'cache-control: no-cache'`<br>

  - **POST** [http://localhost:8080/api/customer] Create a new customer<br>
  
    Body ` { "name":"test","age":99}`<br>

    `curl -X POST \`<br>
        `http://localhost:8080/api/customer \`<br>
        `-H 'Content-Type: application/json' \`<br>
        `-H 'Postman-Token: 3b8a8032-efe0-4dae-b069-ca2993c7c578' \`<br>
        `-H 'cache-control: no-cache' \`<br>
        `-d '{`<br>
            `"name":"test",`<br>
            `"age":99`<br>
        `}'`<br>

  - **PUT** [http://localhost:8080/api/customer/`{customerId}`] Change a specific customer with customer ID<br>
  
    Body `{ "name":"test", "age":40 }`<br>

    `curl -X PUT \`<br>
        `http://localhost:8080/api/customer/100 \`<br>
        `-H 'Content-Type: application/json' \`<br>
        `-H 'Postman-Token: c6f68786-d6ba-48f9-9bd5-3ac5a67e7a15' \`<br>
        `-H 'cache-control: no-cache' \`<br>
        `-d '{`<br>
            `"name":"test",`<br>
            `age":40`<br>
        `}'`<br>
    
  - **DELETE** [http://localhost:8080/api/customer/{customerId}] Remove a customer<br>
  
    `curl -X POST \`<br>
        `http://localhost:8080/api/customer/1 \`<br>
        `-H 'Content-Type: application/json' \`<br>
        `-H 'Postman-Token: 55f12393-9d51-416a-9c0f-c87b487ee529' \`<br>
        `-H 'cache-control: no-cache' \`<br>
        `-d '{`<br>
            `"name":"teste",`<br>
            `"age":34`<br>
        `}'`<br>

# Tools used to develop application

   - **Spring Boot**
        
        Spring boot was used, because it is easier to group the infrastructures settings more easily
   - **Maven**
        
        Maven is an excellent package manager, as being the standard for the spring boot
   - **Apache Tomcat**
        
        Apache Tomcat was used as being the standard for the spring boot
   - **H2 Database**
        
        As no instructions on database usage were provided, we chose to use H2 Database, not only for being portable, but also for not requiring installation
   - **Git**
        
        Easier to use, very user-friendly

# Application infrastructure

   - **Customer**

        It is very  easy to a build package, test and run it, just by installing Java version 8, Apache Tomcat(the most recent version), Maven and Git

        - Run

          Enter a prompt  of command and enter the instructions

          First clone repository in your desktop<br>
          `git clone https://gitlab.com/rafael.soares1984/customer_uol.git`      

          When clone is finished, into the folder<br>
          `cd customer`

          **Unix system**<br>
          ` ./mvnw clean install`

          **Windows**<br>
          `./mvnw.cmd clean install`

          After the command is finished, you can run the app<br>
               `./mvnw spring-boot:run`

        - Test App

          Enter a prompt of command and enter an instruction<br>
               `mvn test`

        - Build App

          Enter a prompt of command and enter as instruction<br>
               `mvn clean install spring-boot:repackage` <br>
          This instruction also tests the app
        
        - Apache Deploy
          
          Copy file `./target/customer.war` to a deploy folder of server
          
## Production Settings

   - First Install Apache Tomcat and set up DNS and IPs on server that will respond to network calls<br>
    
        **Enter a prompt  and go to folder**<br>
          `cd /opt`<br>

        **Download Tomcat**<br>
          `wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-9/v9.0.17/bin/apache-tomcat-9.0.17.tar.gz`<br>

        **Extract Tomcat**<br>
          `tar -xvzfj apache-tomcat-9.0.17.tar.gz`<br>

        **Rename Tomcat folder** <br>
          `mv apache-tomcat-9.0.17 tomcat9` <br>

        **Set Tomcat up for it work**<br>
          Create Script automatically start tomcat on /etc/init.d<br>
             `#!/bin/sh `<br>
             `echo Start Tomcat `<br>
             `export JAVA_HOME=/opt/java `<br>
             `/opt/tomcat9/bin/catalina.sh start`<br>
                  
        Change admin permission<br>
             `chmod +x tomcat`<br>
             
        Add root level system <br>
             `update-rc.d tomcat defaults 99`<br>        
             
        Add root level default<br>
           `ln -n tomcat /etc/rc2.d/S99tomcat `<br>
             
       **Set up tomcat to reply to your network**<br>  
           Sttings server name, ip, virtual network, and other to worked on your network, and deploys folder.
             
   - After installation and settings, install Java version 8 or higher, and setting server JAVA_HOME<br>
        
        When java installation is done, settings JAVA_HOME <br>
          `vim /etc/bash.bashrc`<br>
     
        Add<br>
          `export JAVA_HOME=/opt/java` <br>
          `export PATH=/opt/java/bin:$PATH` <br>
    
   -  Create script for automatic proccess on deploy <br>
   
        Script to copy war file to a /var/lib/tomcat7/webapps or other folder speficiqued in configuration.
