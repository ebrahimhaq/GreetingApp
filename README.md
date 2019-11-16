# GreetingApp
Simple webservice application that is built using Maven and run on docker container

# Commands

`mvnw.cmd clean package`

`docker build -t greetings-app .`

`docker run -p 8080:8080 -t greetings-app`

# Get Calls

For 1: `http://localhost:5000/greeting?userId=1&accountType=&accountName=personal`

For 2: `http://localhost:5000/greeting?userId=&accountType=small&accountName=business`

For 3: `http://localhost:5000/greeting?userId=&accountType=big&accountName=business`


