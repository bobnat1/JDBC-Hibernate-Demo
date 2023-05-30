# JDBC-Hibernate-Demo
a simple demo showcasing JDBC and Hibernate to save/retrieve persistent entities to an SQL database
to use make sure you have an SQL database running on either local host or remote
once SQL server is running then edit the hibernate.cf.xml lines:
        <property name="connection.url">jdbc:mysql://localhost/sms?createDatabaseIfNotExist=true</property>
        <property name="connection.username"></property>
        <property name="connection.password"></property>
to include your sql database username and password, also if you using a remote sql server change jdbc:mysql://localhost/ to your server ip
to have the test demo database populate, run the ConnectionDAOTest.java in JUnit
