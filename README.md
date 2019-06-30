# Build Server Setup
1. Update the OS `sudo yum update -y`
1. Install Java JDK `sudo yum install java-1.8.0-openjdk-devel -y`
1. Install git `sudo yum install git -y'
1. Add the jenkins repo to the list of yum repositories `sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo` 
1. Import public key from Jenkins CI to allow rpm install `sudo rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key`
1. Install Jenkins `sudo yum install jenkins -y`
1. Start Jenkins `sudo service jenkins start`
1. Configure to start Jenkins on server start `sudo systemctl enable jenkins.service`
1. Unlock Jenkins 'http://\<public-ip\>:8080/' - copy key from file specified