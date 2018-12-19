# Accessing Relational Data using JDBC with Spring
This guide walks you through the process of accessing relational data with Spring.

## What you’ll build
You’ll build an application using Spring’s JdbcTemplate to access data stored in a relational database.

## Execute

```
2018-12-19 20:34:31.496  INFO 33160 --- [           main] hello.Application                        : Started Application in 1.026 seconds (JVM running for 2.146)
2018-12-19 20:34:31.497  INFO 33160 --- [           main] hello.Application                        : Creating tables
2018-12-19 20:34:31.500  INFO 33160 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2018-12-19 20:34:31.562  INFO 33160 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2018-12-19 20:34:31.577  INFO 33160 --- [           main] hello.Application                        : Inserting customer record for John Woo
2018-12-19 20:34:31.577  INFO 33160 --- [           main] hello.Application                        : Inserting customer record for Jeff Dean
2018-12-19 20:34:31.577  INFO 33160 --- [           main] hello.Application                        : Inserting customer record for Josh Bloch
2018-12-19 20:34:31.577  INFO 33160 --- [           main] hello.Application                        : Inserting customer record for Josh Long
2018-12-19 20:34:31.595  INFO 33160 --- [           main] hello.Application                        : Customer[id=3, firstName='Josh', lastName='Bloch']
2018-12-19 20:34:31.595  INFO 33160 --- [           main] hello.Application                        : Customer[id=4, firstName='Josh', lastName='Long']
```