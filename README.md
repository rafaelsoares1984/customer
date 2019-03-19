# Customer
This repository is part of a test for a company, he contains an app REST.

Simple CRUD application of customer. 

Application was developed by Rafael Soares.

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

  - **PUT** [http://localhost:8080/api/customer/`{customerId}`] Change a specific customer with customerId<br>
  
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

# Tools used for develop application

   - **Spring Boot**
        
        Spring boot was used, because it is easier to group the infrastructures configurations more easily
   - **Maven**
        
        Maven is an excellent package manager, as being the standard of the spring boot
   - **Apache Tomcat**
        
        Apache Tomcat as being the standard for the spring boot, was used
   - **H2 Database**
        
        Since no instructions on database usage were provided, we chose to use H2 Database, which does not require installation, as well as being portable
   - **GitHUB**
        
        Easier to use, I'm already used to it

# Application infrastructure

   - **Customer**

        Customer is very easy to a build package, test and run, enough install Java version 8, Apache Tomcat more recent version, Maven, Git

        - Run

          Enter a prompt  of command and enter the instructions

          First clone repository in your desktop<br>
          `git clone https://gitlab.com/rafael.soares1984/customer_uol.git`      

          When clone is finish, enter on folder<br>
          `cd customer_uol`

          **Unix system**<br>
          ` ./mvnw clean install`

          **Windows**<br>
          `./mvnw.cmd clean install`

          After the command is finished, you can run other<br>
               `./mvnw spring-boot:run`

        - Test App

          Enter a prompt  of command and enter the instruction<br>
               `mvn test`

        - Build App

          Enter a prompt  of command and enter the instruction<br>
               `mvn clean install spring-boot:repackage` <br>
          This instruction also test of app
        
        - Apache Deploy
          
          Copy file `./target/customer.war` to a deploy folder of server
          
## Setting production

   - First Install Apache Tomcat and configure DNS and IP'S on server that will respond to network calls<br>
    
        **Enter a prompt  and go to folder**<br>
          `cd /opt`<br>

        **Download of Tomcat**<br>
          `wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-9/v9.0.17/bin/apache-tomcat-9.0.17.tar.gz`<br>

        **Extract Tomcat**<br>
          `tar -xvzfj apache-tomcat-9.0.17.tar.gz`<br>

        **Rename Tomcat folder** <br>
          `mv apache-tomcat-9.0.17 tomcat9` <br>

        **Configure apache for work**<br>
          Create Script of start apache on /etc/init.d<br>
             `#!/bin/sh `<br>
             `echo Inicializa tomcat `<br>
             `export JAVA_HOME=/opt/java `<br>
             `/opt/tomcat9/bin/catalina.sh start`<br>
          And change permission<br>
             `chmod +x tomcat`<br>
          Add root level system <br>
             `update-rc.d tomcat defaults 99`<br>        
          Add root level default<br>
             `ln -n tomcat /etc/rc2.d/S99tomcat `
             
       **Configure apache for reply to on your network**<br>  
           Configure server name, ip, virtual network, and other for worked on your network, and folder for deploys.
             
   - After installation and configuration, install Java version 8 or higher, and configure JAVA_HOME of server<br>
        
        It when installation java is done, configure JAVA_HOME  <br>
          `vim /etc/bash.bashrc`<br>
     
        Adding the snippet below<br>
          `export JAVA_HOME=/opt/java` <br>
          `export PATH=/opt/java/bin:$PATH` <br>
    
   -  Create script for automation proccess  or deploy of application<br>
   
        Script to copy war file to a /var/lib/tomcat7/webapps or other folder speficiqued in configuration.
