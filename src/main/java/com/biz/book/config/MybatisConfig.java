package com.biz.book.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.biz.book.mapper")
@EnableTransactionManagement
public class MybatisConfig {
	
	@Bean
	public DataSource dataSource() {
		
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("mybts");
		ds.setPassword("1234");
		
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliasesPackage("com.biz.book.model");
		
		return sqlSessionFactoryBean;
		
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		
		DataSourceTransactionManager ts=new DataSourceTransactionManager(dataSource());
		
		return ts;
	}
}




















