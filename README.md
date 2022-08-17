# Servlet-JSP-JDBC Social Media App

## Local

1. Start database: `docker run -d --rm --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=app -p 5432:5432 postgres` 
2. Run DB script: `docker exec -i postgres psql -U postgres -d app < sql/data.sql`
3. `mvn tomcat7:run`
