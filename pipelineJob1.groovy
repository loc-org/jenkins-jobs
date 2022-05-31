
pipeline {
    agent {
        ecs {
            inheritFrom 'build-example-spot'
        }
    }
    triggers {
        githubPush()
    }
    environment {
        NEW_VERSION = '1.3.0'
        GITHUB_CREDENTIALS = credentials('github')
    }
    stages {
        stage('Build') {
            steps {
                echo "this was executed on a spot instance"
                echo "deploying with ${GITHUB_CREDENTIALS}"
                withCredentials([
                    usernamePassword(credentialsId: 'github', usernameVariable: 'USER', passwordVariable: 'PASSWORD')
                ]) {
                    echo "some script ${USER} ${PASSWORD}"
                }
                // withCredentials([
                //     usernamePassword(credentialsId: 'mycreds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')
                //     ]) {
                //     sh 'cf login some.awesome.url -u $USERNAME -p $PASSWORD'
                // }
            }
        }
        stage('Test') {
            steps {
                echo "deploying the application"
            }
        }
    }
}
