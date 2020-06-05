#!/usr/bin/env groovy

pipeline {
    agent {
        docker {
            image 'gradle:6.4.1-jdk8'
            args '-u gradle -v "$PWD":/home/gradle/project -w /home/gradle/project'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle build -x test'
            }
        }
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}