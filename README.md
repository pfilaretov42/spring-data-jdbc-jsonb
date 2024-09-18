# spring-data-jdbc-jsonb

The project shows how to work with jsonb column using Spring Data JDBC.

# How to run

- Start PostgreSQL locally:
  ```shell
  docker-compose -f ./docker/local-infra.yaml up
  ```
- Connect to PostgreSQL on `localhost:5432` with `postgres`/`postgres` user/password and create database and user:
  ```sql
  create database spring_data_jdbc_jsonb;
  create user spring_data_jdbc_jsonb with encrypted password 'spring_data_jdbc_jsonb';
  grant all privileges on database spring_data_jdbc_jsonb to spring_data_jdbc_jsonb;
  alter database spring_data_jdbc_jsonb owner to spring_data_jdbc_jsonb;
  ```
- Run Spring Boot application `SpringDataJdbcJsonbApplication`.
- Liquibase will create database table(s) and initial data on the application startup.