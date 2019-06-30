node {
    stage('Say hello') {
        echo 'Hello World'
    }
    stage('Git checkout') {
        git 'https://github.com/Dazza65/Senza'
    }
    stage('Gradle Build') {
        sh './gradlew clean war'
    }
}