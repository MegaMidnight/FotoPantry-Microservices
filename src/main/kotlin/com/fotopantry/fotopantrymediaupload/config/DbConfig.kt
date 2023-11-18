package com.fotopantry.fotopantrymediaupload.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DbConfig {

    // Database host, port, name, username, and password are injected from k8s env.
    @Value("\${SQL_SERVER:localhost}")
    private lateinit var dbHost: String

    @Value("\${SQL_PORT:3306}")
    private lateinit var dbPort: String

    @Value("\${SQL_DATABASE:test}")
    private lateinit var dbName: String

    @Value("\${SQL_USERNAME:root}")
    private lateinit var dbUser: String

    @Value("\${SQL_PASSWORD:password}")
    private lateinit var dbPassword: String

    // SSL properties are injected from k8s env.
    @Value("\${MYSQL_USE_SSL:false}")
    private lateinit var useSSL: String

    @Value("\${MYSQL_CA_CERT:}")
    private lateinit var caCert: String

    @Value("\${MYSQL_TRUSTSTORE:}")
    private lateinit var trustStore: String


    /**
     * Creates and configures a DataSource for the MySQL database.
     *
     * @return A DataSource configured with the MySQL connection details.
     */
    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver")
        dataSource.url = "jdbc:mysql://$dbHost:$dbPort/$dbName?useSSL=$useSSL&requireSSL=true&enabledSslProtocolSuites=TLSv1,TLSv1.1,TLSv1.2&trustCertificateKeyStoreUrl=$caCert&trustCertificateKeyStorePassword=$trustStore"
        dataSource.username = dbUser
        dataSource.password = dbPassword
        return dataSource
    }
}