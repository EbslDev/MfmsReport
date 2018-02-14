config jndi @Tomcat
===================
add line to context.xml:

<Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="100" maxIdle="30" maxWait="10000" name="jdbc/MySqlEpatrolDB" password="PeppaPig0513" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/epatrol" username="root"/>    

config using log4j @Tomcat
==========================
1. copy log4j.properties to $CATALINA_HOME\conf
2. edit log4j.properties to specify the logging location
	log4j.appender.file.File=/mfms.log
3. @Project/extra_libs, copy (original name) tomcat-extras-juli-8.5.2.jar to (replace) $CATALINA_HOME/bin/tomcat-juli.jar (target name)
4. @Project/extra_libs, copy all files including tomcat-extras-juli-adapters-8.5.2.jar to $CATALINA_HOME/lib

5. add line to tomcat start script:
	-Dlog4j.configuration="file:d:\apache-tomcat-8.5.27\conf\log4j.properties"
	(if for eclipse, stop tomcat server, double click Tomcat v8.5 Server at localhost, @Open launch configuration, click Arguments tag and append line to the argument