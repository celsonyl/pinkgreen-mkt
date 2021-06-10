#!/bin/bash
set -e

createDatabase () {
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
      CREATE DATABASE $1;
      GRANT ALL PRIVILEGES ON DATABASE $1 TO $POSTGRES_USER;
EOSQL
}

if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
	for databaseName in $(echo $POSTGRES_MULTIPLE_DATABASES | tr ',' ' '); do
		createDatabase "$databaseName"
	done
fi

