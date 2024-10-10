
# Project Setup Instructions

Before running the setup script, make sure to grant executable permissions to the script file:

```bash
chmod +x setup.sh
```
install dos2unix

```bash
sudo apt install dos2unix
```

```bash
dos2unix setup.sh
```





to run command:
```bash
sudo ./setup.sh
```


brnach name:
```
main
```
Swagger for User service


http://localhost:8080/swagger-ui/index.html#/

Swagger for Order service

http://localhost:8081/swagger-ui/index.html#/

For Windows, you can run the setup script using:

```cmd
setup.bat
```

### Change Ownership and Permissions

Make sure to change the ownership of the microservices directory:

```bash
sudo chown -R $USER:$USER /microservices
```

Finally, set the necessary permissions for the order management service build directory:

```bash
sudo chmod -R 777 microservices/parent-micro-service/order-management-service/build
```
if containers already running
```bash
sudo docker rm hazelcast_instance
```

```bash
sudo docker rm my_postgres_db
```

```bash
sudo docker rm userMicroService
```

```bash
sudo docker rm orderMicroService
```


to authenticate secured endpoint pass token as Bearer Token in postman


### Requirements:
docker


### Note:

```./setup.sh```  command is recommended.

