pipeline {
    agent any
    tools {
      maven 'Maven' 
    }
    stages {
        stage("Test") {
            steps {
                sh 'mvn clean test -f deliverable_3/BinaryCalculatorWebapp/pom.xml'
            }
        }
        stage("Build") {
            steps {
                sh 'mvn clean package -f deliverable_3/BinaryCalculatorWebapp/pom.xml'
            }
        }
        stage("Package") {
          steps {
            sh 'echo "run docker"'
          }
        }
    }
}
