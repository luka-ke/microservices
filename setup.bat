@echo off
REM Set variables
SET PROJECT_DIR=%cd%
SET ORDER_SERVICE_DIR=%PROJECT_DIR%\order-management-service
SET USER_SERVICE_DIR=%PROJECT_DIR%\user-management-service

REM Function to build Spring Boot applications
:build_apps
echo Building Spring Boot applications...
cd "%ORDER_SERVICE_DIR%"
CALL gradlew clean build
IF ERRORLEVEL 1 (
    echo Build failed for order-management-service.
    EXIT /B 1
)
cd "%USER_SERVICE_DIR%"
CALL gradlew clean build
IF ERRORLEVEL 1 (
    echo Build failed for user-management-service.
    EXIT /B 1
)
echo Build completed.
GOTO :EOF

REM Function to build Docker images
:build_docker_images
echo Building Docker images...
docker-compose build
IF ERRORLEVEL 1 (
    echo Docker image build failed.
    EXIT /B 1
)
echo Docker images built.
GOTO :EOF

REM Function to start Docker containers
:start_containers
echo Starting Docker containers...
docker-compose up --build
IF ERRORLEVEL 1 (
    echo Failed to start Docker containers.
    EXIT /B 1
)
echo Docker containers started.
GOTO :EOF

REM Main execution flow
CALL :build_apps
CALL :build_docker_images
CALL :start_containers

echo Setup completed successfully.
