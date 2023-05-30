# JDBC-Hibernate-Demo
a simple demo showcasing JDBC and Hibernate to save/retrieve persistent entities to an SQL database<br>
to use make sure you have an SQL database running on either local host or remote<br>
once SQL server is running then edit the hibernate.cf.xml lines:<br>
        <pre><property name="connection.url">jdbc:mysql://localhost/sms?createDatabaseIfNotExist=true</property><br>
        <property name="connection.username"></property><br>
        <property name="connection.password"></property><br></pre>
to include your sql database username and password, also if you using a remote sql server change jdbc:mysql://localhost/ to your server ip<br>
to have the test demo database populate, run the ConnectionDAOTest.java in JUnit<br>
