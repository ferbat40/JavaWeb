#!/bin/sh
mvn clean package && docker build -t com.mycompany/AulaPraticaWeb .
docker rm -f AulaPraticaWeb || true && docker run -d -p 9080:9080 -p 9443:9443 --name AulaPraticaWeb com.mycompany/AulaPraticaWeb