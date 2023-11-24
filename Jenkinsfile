pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package'
                    sh ''' mvn clean verify sonar:sonar -Dsonar.projectKey=student-management-system -Dsonar.projectName=student-management-system -Dsonar.host.url=http://localhost:9000 -Dsonar.jdbc.url=jdbc:postgresql://host.docker.internal:5432/postgres'''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }
    }
}