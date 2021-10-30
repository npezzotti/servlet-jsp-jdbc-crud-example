# servlet-jsp-jdbc-crud-example

## Start DB:

`docker run --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=app -p 5432:5432 -d --rm postgres` 
`docker container cp sql/create-user-table.sql postgres:.`
`docker exec -i postgres psql -U postgres -d app -f create-user-table.sql`

