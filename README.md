# What's this

Testcase of bellow issue:

- 

# How to setup environment(RDBMS, JDBC driver maven module)

See:

- https://github.com/yukihane/prefs/tree/master/vagrantfiles/sybase
- https://github.com/yukihane/prefs/tree/master/vagrantfiles/sybase/jdbc-driver-installation

# How to execute

Create a table in `mydb` database:

    use mydb
    go
    
    create table longvarchar_table (
      longvarchar_column char(1024)
    )
    go

Execute:

    mvn test
