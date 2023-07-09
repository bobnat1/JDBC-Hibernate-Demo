# JDBC-Hibernate-Demo
a simple demo showcasing JDBC and Hibernate to save/retrieve persistent entities to an SQL database<br>

# Features
Save and Retrieve persistent entities to a MySQL server
# Usage
make sure you have an SQL database running on either local host or remote<br>
once SQL server is running then edit the hibernate.cf.xml lines:<br>

```xml
<property name="connection.url">jdbc:mysql://localhost/sms?createDatabaseIfNotExist=true</property><br>
```

```xml
<property name="connection.username"></property><br>
```

```xml
<property name="connection.password"></property><br>
```

include your sql database username and password<br>
also if you are using a remote sql server change jdbc:mysql://localhost/ to your server ip<br>
to populate the test demo database populate, run the ConnectionDAOTest.java in JUnit<br>
