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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.example.db.bizA.mapper",sqlSessionFactoryRef="bizASqlSessionFactory")
@EnableTransactionManagement
public class BizADatasourceConfig {

    @Primary
    @Bean(name = "bizADataSource")
    @ConfigurationProperties(prefix="spring.datasource.biza")
    public DataSource bizADataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "bizASqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("bizADataSource") DataSource bizADataSource, ApplicationContext applicationContext) throws Exception{

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bizADataSource);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/bizA/*.xml"));

        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = "bizATransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("bizADataSource") DataSource bizADataSource) {
        return new DataSourceTransactionManager(bizADataSource);
    }

}
