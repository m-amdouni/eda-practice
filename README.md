### eda-practice

## prerequisites :
- prepare kafka container 
```shell
docker-compose up -d  with this content to prepare kafka 
```
content of the docker-compose file : 

```shell
version: "3.4"

services:
  zookeeper:
    image: bitnami/zookeeper
    restart: always
    ports:
      - "2181:2181"
    volumes:
      - "zookeeper_data:/bitnami"
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
  kafka:
    image: bitnami/kafka
    ports:
      - "9092:9092"
    restart: always
    volumes:
      - "kafka_data:/bitnami"
    environment:
      - KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
      - KAFKA_LISTENERS=PLAINTEXT://:9092
      - KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092
    depends_on:
      - zookeeper

volumes:
  zookeeper_data:
    driver: local
  kafka_data:
    driver: local
   
networks:
  default:
    external:
      name: techbankNet
```
- launch mongo db container
```shell
docker run -it -d --name mongo-container -p 27017:27017 --network techbankNet --restart always -v mongodb_data:/data/db mongo:latest
```
- launch mysql db container
```shell
docker run -it -d --name mysql-container -p 3306:3306 --network techbankNet  -e MYSQL_ROOT_PASSWORD=changeit  --restart always -v mysql_data_container:/var/lib/mysql mysql:latest
```

- launch adminer container
```shell
docker run -it -d --name adminer-container -p 8180:8080 --network techbankNet -e ADMINER_DEFAULT_SERVER=mysql-container --restart always adminer:latest
```
## prepare command project
- initialize a spring boot project with the following dependencies :
      - spring-web
      - spring for apache kafka
      - spring data mongo db
      - lombok
 
 


