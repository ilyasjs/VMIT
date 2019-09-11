# ITVM
###### A free and open-source school management suite in Java EE.

### Prerequisites
Create a persistence jta data source for your postgresql db
```
create-jdbc-connection-pool \
--datasourceclassname org.postgresql.ds.PGSimpleDataSource \ 
--restype javax.sql.XADataSource \
--property portNumber=5432:password=DBPASSWORD:user=DBUSER:serverName=DBHOST:databaseName=DBNAME \
jpa_DBNAME_postgresql_pool
```
```
create-jdbc-resource --connectionpoolid jpa_DBNAME_postgresql_pool jdbc/DBNAME
```