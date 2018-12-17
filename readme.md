This repo uses akka-persistence-query and connects to Redis journal. 

Make sure to update your redis config in /src/main/resources/application.conf
### compile
sbt compile

### run
sbt run

### create container
sbt docker:publishLocal

### run container
docker run --rm -d -p8080:8080 cqrs-aggregator:1.0