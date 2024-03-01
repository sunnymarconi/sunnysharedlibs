def call(ip,user,credId){
  sshagent([credId]) {
    sh "mv target/myweb-0.0.9.war target/app.war"
    sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat9/webapps"
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
