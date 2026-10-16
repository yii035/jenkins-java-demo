pipeline {
    agent any

    tools {
        // Tên tool cần khớp chính xác với cấu hình trong Manage Jenkins > Tools
        maven 'Maven3'
        jdk 'JDK25'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Checkout') {
            steps {
                // Lấy mã nguồn từ GitHub
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                bat 'mvn -B package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Run') {
            steps {
                bat 'java -jar target\\jenkins-java-demo-1.0.0.jar'
            }
        }
    }

    post {
        success {
            echo 'Pipeline chạy thành công!'
        }
        failure {
            echo 'Pipeline thất bại, kiểm tra Console Output.'
        }
    }
}