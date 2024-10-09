#!/bin/bash

# Set variables
PROJECT_DIR=$(pwd)
ORDER_SERVICE_DIR="$PROJECT_DIR/order-management-service"
USER_SERVICE_DIR="$PROJECT_DIR/user-management-service"

# Function to build Spring Boot applications
build_apps() {
    echo "Building Spring Boot applications..."
    (cd "$ORDER_SERVICE_DIR" && ./gradlew clean build)
    (cd "$USER_SERVICE_DIR" && ./gradlew clean build)
    echo "Build completed."
}

# Function to build Docker images
build_docker_images() {
    echo "Building Docker images..."
    sudo docker-compose build
    echo "Docker images built."
}

# Function to start Docker containers
start_containers() {
    echo "Starting Docker containers..."
    sudo docker-compose up --build
    echo "Docker containers started."
}

# Function to initialize database (if necessary)

# Main execution flow
build_apps
build_docker_images
start_containers


echo "Setup completed successfully."
