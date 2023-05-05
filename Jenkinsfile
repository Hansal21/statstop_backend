pipeline {
     environment{
        dockerimage=""
    }
    agent any
    stages {
        stage('Git clone') {
            steps {
            git branch: 'main',credentialsId:'statstop_github',url: 'https://github.com/Hansal21/statstop_backend.git'
            }
        }
       stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Build Image') {
            steps {
                script{
                    dockerimage=docker.build "statstop/statstop_backend:latest"
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script{
                    docker.withRegistry('','statstop_dockerhub'){
                    dockerimage.push()
                    }
                }
            }
        }
        stage('Ansible pull Docker Image') {
            steps {
              ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true,
              inventory: 'inventory', playbook: 'ansible-playbook.yml', sudoUser: null
            }
        }
    }
}
