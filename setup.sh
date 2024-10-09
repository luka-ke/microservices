#!/bin/bash

# Set variables
PROJECT_DIR=$(pwd)
ORDER_SERVICE_DIR="$PROJECT_DIR/order-management-service"
USER_SERVICE_DIR="$PROJECT_DIR/user-management-service"

convert_files() {
    echo "Converting gradlew files from DOS to Unix format..."
    dos2unix "$ORDER_SERVICE_DIR/gradlew"
    dos2unix "$USER_SERVICE_DIR/gradlew"
    echo "Conversion completed."
}
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
convert_files
build_apps
build_docker_images
start_containers


echo "Setup completed successfully."
