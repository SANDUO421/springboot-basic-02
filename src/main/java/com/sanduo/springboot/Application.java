package com.sanduo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sanduo.springboot.repository.CustomerRepositoryFactoryBean;

/**
 * springboot的启动类
 * 
 * @author sanduo
 * @date 2018/07/02
 */
@EnableCaching // 开启缓存支持
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomerRepositoryFactoryBean.class) // 开启jpa支持
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
