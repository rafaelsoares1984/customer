# customer
This repository is part of a test for a company, he contains a app REST.

Simple CRUD application of customer. 

Application was developed by Rafael Soares.

##  URL of project

    This app has some urls

  - **Service - API** [http://localhost:8080/api/customer]  
  - **Swagger - Documentation of API** [http://localhost:8080/swagger-ui.html] 
  - **H2 - Database** [http://localhost:8080/h2] 

# Functionalities of Application - Endpoints

    Some Endpois:

  - **GET** [http://localhost:8080/api/customer] - List all customer
   
    `curl -X GET \
        http://localhost:8080/api/customer/ \
        -H 'Postman-Token: 0483fb3a-d9db-4f17-98a5-d2c3cc2987fa' \
        -H 'cache-control: no-cache'`

  - **GET** [http://localhost:8080/api/customer/`{cusmoterId}`] - Get a specific customer

    `curl -X GET \
        http://localhost:8080/api/customer/1 \
        -H 'Postman-Token: 0483fb3a-d9db-4f17-98a5-d2c3cc2987fa' \
        -H 'cache-control: no-cache'`

  - **POST** [http://localhost:8080/api/customer] Create a new customer
  
    Body ` { "name":"test","age":99}`

    `curl -X POST \
        http://localhost:8080/api/customer \
        -H 'Content-Type: application/json' \
        -H 'Postman-Token: 3b8a8032-efe0-4dae-b069-ca2993c7c578' \
        -H 'cache-control: no-cache' \
        -d '{
            "name":"test",
            "age":99
        }'`

  - **PUT** [http://localhost:8080/api/customer/`{customerId}`] Change a specific customer with customerId
  
    Body `{ "name":"test", "age":40 }`

    `curl -X PUT \
        http://localhost:8080/api/customer/100 \
        -H 'Content-Type: application/json' \
        -H 'Postman-Token: c6f68786-d6ba-48f9-9bd5-3ac5a67e7a15' \
        -H 'cache-control: no-cache' \
        -d '{
            "name":"test",
            "age":40
        }'`
    
  - **DELETE** [http://localhost:8080/api/customer/{customerId}] Remove a custmer
    `curl -X POST \
        http://localhost:8080/api/customer/1 \
        -H 'Content-Type: application/json' \
        -H 'Postman-Token: 55f12393-9d51-416a-9c0f-c87b487ee529' \
        -H 'cache-control: no-cache' \
        -d '{
            "name":"teste",
            "age":34
        }'`

# Tools used for develop application

   - **Spring Boot**
        
        Spring boot was used, because it is easier to group the infrastructures configurations more easily
   - **Maven**
        
        Maven is an excellent package manager, as being the standard of the spring boot
   - **Apache Tomcat**
        
        Apache Tomcat as being the standard for the spring boot, was used
   - **H2 Database**
        
        Since no instructions on database usage were provided, we chose to use H2 Database, which does not require installation, as well as being portable
   - **Gitlab**
        
        Easier to use, I'm already used to it

# Application infrastructure

   - **Custmoer**

        Customer is very easy to a build package, test and run, enough install Java version 8, Apache Tomcat more recent version, Maven, Git

        - Run

          Enter a prompot of command and enter the instructions

          Fisrt clone repositóry in your desktop<br>
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

          Enter a promot of command and enter the instruction<br>
               `mvn test`  or  `mvn compile-test`

        - Build App

          Enter a promot of command and enter the instruction<br>
               `mvn clean install spring-boot:repackage` 
        
        - Apache Deploy
          
          Copy file `./target/customer.war` to a deply folder of server