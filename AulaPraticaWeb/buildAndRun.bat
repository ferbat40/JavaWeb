@echo off
call mvn clean package
call docker build -t com.mycompany/AulaPraticaWeb .
call docker rm -f AulaPraticaWeb
call docker run -d -p 9080:9080 -p 9443:9443 --name AulaPraticaWeb com.mycompany/AulaPraticaWeb