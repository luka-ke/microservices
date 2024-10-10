@echo off
setlocal

:: Set variables
set "PROJECT_DIR=%cd%"
set "ORDER_SERVICE_DIR=%PROJECT_DIR%\order-management-service"
set "USER_SERVICE_DIR=%PROJECT_DIR%\user-management-service"

:: Function to build Spring Boot applications
echo Building Spring Boot applications...
cd /d "%ORDER_SERVICE_DIR%" && call gradlew clean build
if errorlevel 1 (
    echo Failed to build order-management-service. Exiting...
    exit /b 1
)
cd /d "%USER_SERVICE_DIR%" && call gradlew clean build
if errorlevel 1 (
    echo Failed to build user-management-service. Exiting...
    exit /b 1
)
echo Build completed.

:: Function to build Docker images
echo Building Docker images...
docker-compose build
if errorlevel 1 (
    echo Failed to build Docker images. Exiting...
    exit /b 1
)
echo Docker images built.

:: Function to start Docker containers
echo Starting Docker containers...
docker-compose up --build
if errorlevel 1 (
    echo Failed to start Docker containers. Exiting...
    exit /b 1
)
echo Docker containers started.

:: Final message
echo Setup completed successfully.

endlocal
exit /b 0
