@echo off
call mvn clean package
call docker build -t com.mycompany/Aula4Praticax2 .
call docker rm -f Aula4Praticax2
call docker run -d -p 9080:9080 -p 9443:9443 --name Aula4Praticax2 com.mycompany/Aula4Praticax2