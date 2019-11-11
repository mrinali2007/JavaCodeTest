# JavaCodeTest

This is the Repository mainting Java command line maven project to perform various operations as per user input under folder person and JPA data layer maven project to perform data operation request received from command line into mongo db under project dataLayer. 

JARS to execute:- 

dataLayer-0.0.1-SNAPSHOT.jar --> To start the micorservice for data persistence layer.
person-0.0.1-SNAPSHOT.jar  -->  To start the client layer for command line operation.

Download Mongo :- 
[MongoDB Download Center](https://www.mongodb.com/download-center/community?jmp=docs).
Running this project involves three steps:- 

Step 1: Installing mongo db locally

    a.) Download the MongoDB .tar.gz tarball. Download the tarball for your system from the 
        [MongoDB Download Center](https://www.mongodb.com/download-center/community?jmp=docs).
    b.) Extract the files from the downloaded archive.
        tar -zxvf mongodb-macos-x86_64-4.2.1.tgz
    c.) Ensure the binaries are in a directory listed in your PATH environment variable.
           The MongoDB binaries are in the bin/ directory of the tarball. 
    d.) Copy the binaries into a directory listed in your PATH variable, 
        such as /usr/local/bin (Update /path/to/the/mongodb-directory/ with your installation directory as appropriate)
        sudo cp /path/to/the/mongodb-directory/bin/* /usr/local/bin/
    e.) Create the data directory
        mkdir -p /data/db
    d.) chmod 755 /data/* and chmod 755 /data
    e.) Run mongod
    



Step 2: Running the JPADataLayer microservice in background

        a.) Run the follwing command to start the microservice 
              nohup java -jar dataLayer-0.0.1-SNAPSHOT.jar &
              
        b.) Microservice should be up & running at localhost:8080 with 5 endpoints
            POST /person/add
            PUT /person/edit/{id}
            GET /person/count
            GET /person/list
            POST /person/delete/{id}

Step 3: Running the JavaCommandLine project

        a.) run the following command to finally start the project for command line operations
            java -jar person-0.0.1-SNAPSHOT.jar
            
            
Step 4: Once you exit the command line application stop below two process:-

     1. Exit mongo db terminal by CTRL+C
     2. Kill the java process of running the data layer by 
         ps -ef|grep java
         kill -9 <process id>
