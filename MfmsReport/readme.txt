config jndi @Tomcat
===================
add line to context.xml:

<Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="100" maxIdle="30" maxWait="10000" name="jdbc/MySqlEpatrolDB" password="PeppaPig0513" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/epatrol" username="root"/>    
