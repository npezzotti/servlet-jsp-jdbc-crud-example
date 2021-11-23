# servlet-jsp-jdbc-crud-example

1. Start database: `docker run --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=app -p 5432:5432 -d --rm postgres` 
2. Run DB script: `docker container cp sql/data.sql postgres:. && docker exec -i postgres psql -U postgres -d app -f data.sql`

