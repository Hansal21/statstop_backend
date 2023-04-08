pipeline {
    agent any

    stages {
        stage("ANSIBLE - Backend Server")
        {
            steps
            {
                sh 'ansible-playbook -i Inventory DeployPlaybook.yaml'
            }
        }
    }
}