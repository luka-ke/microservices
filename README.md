
# Project Setup Instructions

Before running the setup script, make sure to grant executable permissions to the script file:

```bash
chmod +x setup.sh
```

Before executing `./setup.sh`, ensure you have the required permissions.

Install OpenJDK 17 by running the following command:

```bash
sudo apt install openjdk-17-jdk
```

Once OpenJDK is installed, you can run the setup script directly on Linux:

```bash
sudo ./setup.sh
```

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
