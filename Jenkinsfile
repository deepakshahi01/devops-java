pipeline {
    agent any
            tools{
                jdk 'JDK17'
                gradle 'gradle-8.5'
            }
	environment{
		DEFAULT_RECIPIENT = 'shahideep0901@gmail.com'
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
		archiveArtifacts artifacts:"build/libs/**/*.jar", fingerprint:true

            }
        }
        stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
	post {
        success {
            emailext (
                to: "${DEFAULT_RECIPIENT}",
                subject: "✅ SUCCESS: ${env.JOB_NAME} [Build #${env.BUILD_NUMBER}]",
                body: """<p>The build finished successfully.</p>
                         <p><strong>Job:</strong> ${env.JOB_NAME}<br>
                         <strong>Build:</strong> #${env.BUILD_NUMBER}</p>
                         <p>Check the details here: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                to: "${DEFAULT_RECIPIENT}",
                subject: "❌ FAILURE: ${env.JOB_NAME} [Build #${env.BUILD_NUMBER}]",
                body: """<p>Something went wrong during the build.</p>
                         <p><strong>Logs:</strong> <a href="${env.BUILD_URL}console">${env.BUILD_URL}console</a></p>""",
                mimeType: 'text/html',
                attachLog: true // This is a lifesaver!
            )
        }
    }

}
