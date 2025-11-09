#!/bin/bash
echo "Starting Kindle Library Management System on Railway..."
echo "Database Host: $MYSQLHOST"
echo "Database Port: $MYSQLPORT"
echo "Database Name: $MYSQLDATABASE"
echo "Database User: $MYSQLUSER"
echo "Application Port: $PORT"

# Wait for MySQL to be ready
echo "Waiting for MySQL database to be ready..."
while ! nc -z $MYSQLHOST $MYSQLPORT; do
  echo "Waiting for MySQL at $MYSQLHOST:$MYSQLPORT..."
  sleep 2
done
echo "MySQL is ready!"

# Start the application
echo "Starting Spring Boot application..."
exec java -Dserver.port=$PORT -Dspring.profiles.active=production -jar target/kindle-library-1.0.0.jar