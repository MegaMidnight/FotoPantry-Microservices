package com.fotopantry.fotopantrymediaupload.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DbConfig {

    // Database host, port, name, username, and password are injected from k8s env.
    @Value("\${SQL_SERVER}")
    private var dbHost: String? = null

    @Value("\${SQL_PORT}")
    private var dbPort: String? = null

    @Value("\${SQL_DATABASE}")
    private var dbName: String? = null

    @Value("\${SQL_USERNAME}")
    private var dbUser: String? = null

    @Value("\${SQL_PASSWORD}")
    private var dbPassword: String? = null

    // SSL properties are injected from k8s env.
    @Value("\${MYSQL_USE_SSL}")
    private var useSSL: String? = null

    @Value("\${MYSQL_CA_CERT}")
    private var caCert: String? = null

    @Value("\${MYSQL_TRUSTSTORE}")
    private var trustStore: String? = null


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