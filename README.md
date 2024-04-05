# spring-data-jdbc-jsonb

The project shows how to work with jsonb column using Spring Data JDBC.

# How to run

- Start PostgreSQL locally on port 5432, e.g., in Docker.
- Create database and user:
  ```sql
  create database spring_data_jdbc_jsonb;
  create user spring_data_jdbc_jsonb with encrypted password 'spring_data_jdbc_jsonb';
  grant all privileges on database spring_data_jdbc_jsonb to spring_data_jdbc_jsonb;
  ```
- Run Spring Boot application `SpringDataJdbcJsonbApplication`.
- Liquibase will create database table(s) on the application startup.