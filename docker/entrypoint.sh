#!/bin/sh

set -e  # wyjdź przy błędzie

echo "⏳ Waiting for MySQL on mysql:3306..."

# 🔧 Czekamy aż port 3306 będzie otwarty na kontenerze mysql
/wait-for-it.sh mysql:3306 --timeout=30 --strict -- echo "✅ MySQL is up!"

# Budujemy URL do bazy
export DATABASE_URL="jdbc:mysql://mysql:3306/${MYSQL_DATABASE}"
export SPRING_DATASOURCE_URL="${DATABASE_URL}"

echo "🔧 DATABASE_URL=${DATABASE_URL}"
echo "🔧 SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}"

# Uruchamiamy aplikację
exec java -jar app.jar
