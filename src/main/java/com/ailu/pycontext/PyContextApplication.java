package com.ailu.pycontext;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.ailu.pycontext.dao.mapper")
public class PyContextApplication {

	public static ApplicationContext applicationContext;

	@Autowired
	private Environment env;

	@Autowired
	private PageInterceptor pageInterceptor;

	public static void main(String[] args) {
		applicationContext=SpringApplication.run(PyContextApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(dataSource);
		//该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
		fb.setPlugins(new Interceptor[]{pageInterceptor});
		fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
		return fb.getObject();
	}
}
