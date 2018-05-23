package com.an9elkiss.api.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan(basePackages = {
		"com.an9elkiss.api.user.api, com.an9elkiss.api.user.service, com.an9elkiss.commons.util.spring" })
@MapperScan("com.an9elkiss.api.user.dao")
public class UnionUserApiBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(UnionUserApiBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
    

	/**
	 * 实现封装PUT请求的From体至Command
	 * @return
	 */
    @Bean
    public FilterRegistrationBean httpPutFormContentFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
        registration.setFilter(httpPutFormContentFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
    
    /**
     * 允许跨域请求。swagger可能发起跨域请求
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
            }
        };
    }

}
