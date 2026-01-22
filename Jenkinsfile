pipeline {
    agent any
            tools{
                jdk 'JDK17'
                gradle 'gradle-8.5'
            }
    stages {
        stage('build') {
            steps {
                echo 'building'
                sh 'java --version'
                sh 'gradle --version'
            }
        }
        stage('test') {
            steps {
                echo 'testing'
            }
        }
        stage('archive') {
            steps {
                echo 'archiving'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}
