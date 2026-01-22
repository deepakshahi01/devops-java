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
                sh '''
			java --version
                	gradle --version
			gradle clean build
		'''
            }
        }
        stage('test') {
            steps {
                echo 'testing'
		sh '''
			gradle test
			gradle jacocoTestReport
		'''
            }
        }
        stage('archive') {
            steps {
                echo 'archiving'
		archiveArtifacts artifacts:"build/*", fingerprint:true
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}
