package com.ryz.cn.springbootvuemvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages="com.ryz.cn.springbootvuemvc")
@EntityScan(basePackages="com.ryz.cn.springbootvuemvc.pojo")
@EnableJpaRepositories(basePackages="com.ryz.cn.springbootvuemvc.repository")
@SpringBootApplication
@EnableCaching
public class SpringbootvuemvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootvuemvcApplication.class, args);
	}
}
