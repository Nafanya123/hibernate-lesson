package com.example.demo.configs;

import org.hibernate.Session;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


//@Configuration
//Аннотация для включения репозиториев JPA
//@EnableJpaRepositories("com.example.demo.repository")
////Включает возможность управления транзакциями Spring на основе аннотаций @Transaction
//@EnableTransactionManagement
public class PersistenceJPAConfig {

    //Бин конфигурации БД
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("root");
//        return dataSource;
//    }

    //ContainerEntityManager для управлении сессии
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.example.demo");
////        factory.setDataSource(dataSource());
//        return factory;
//    }

    //для работы с транзакциями
//    @Bean
//    public PlatformTransactionManager transactionManager(SessionProvider sessionProvider) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        Session session = sessionProvider.getPublicSession();
//        txManager.setEntityManagerFactory(session.getEntityManagerFactory());
//        return txManager;
//    }
}
