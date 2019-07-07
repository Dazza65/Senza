# Senza music service

*senza
preposition /’sɛntsa, ’sentsa/
without*

## Description
Sample Java project to provide a REST API using JAX-RS to retrieve song information from the [Million Song Dataset](http://millionsongdataset.com)

The project is less about the Java code but more about configuring the CI/CD pipeline.  
It then looks to extend this further by introducing Servless concepts both for the application functionality and also the build process.

## Assumptions
- All of the build process and delivery of the project is using [Amazon Web Services](aws.amazon.com)
- It is assumed that you can clone the git repo and get the project setup in your IDE of choice.
- I'm using Gradle as the build and dependency automation tool.

## Setup (non-serverless)

### Build Server Setup
The non-serverless architecture is going to use Jenkins and the CI/CD delivery pipeline, installed on a t2.micro EC2 instance.
1. Update the OS `sudo yum update -y`
1. Install Java JDK `sudo yum install java-1.8.0-openjdk-devel -y`
1. Install git `sudo yum install git -y'
1. Add the jenkins repo to the list of yum repositories `sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo` 
1. Import public key from Jenkins CI to allow rpm install `sudo rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key`
1. Install Jenkins `sudo yum install jenkins -y`
1. Start Jenkins `sudo service jenkins start`
1. Configure to start Jenkins on server start `sudo systemctl enable jenkins.service`
1. Unlock Jenkins 'http://\<public-ip\>:8080/' - copy key from file specified
1. Configure GitHub webhook to trigger Jenkins build (TBC)
1. Create Jenkins build (TBC)

### Data Repository Setup
To be completed

### Project Setup
#### Fork GitHub repo
#### Clone repository


## Setup (Serverless)
To be completed