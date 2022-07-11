package com.example.db.datasource.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.example.db.bizB.mapper",sqlSessionFactoryRef="bizBSqlSessionFactory")
@EnableTransactionManagement
public class BizBDatasourceConfig {

    @Bean(name = "bizBDataSource")
    @ConfigurationProperties(prefix="spring.datasource.bizb")
    public DataSource bizBDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bizBSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("bizBDataSource") DataSource bizBDataSource, ApplicationContext applicationContext) throws Exception{

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bizBDataSource);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/bizB/*.xml"));

        return sessionFactory.getObject();
    }

    @Bean(name = "bizBTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("bizBDataSource") DataSource bizBDataSource) {
        return new DataSourceTransactionManager(bizBDataSource);
    }

}
