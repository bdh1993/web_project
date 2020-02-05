package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value= {"com.example.demo.mapper"})
@EnableTransactionManagement
public class DatabaseConfig {

	/**
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}
}
