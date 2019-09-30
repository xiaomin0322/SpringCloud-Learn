package org.spring.cloud.consumer.feign.hystrix;

import org.spring.cloud.consumer.feign.hystrix.config.ExcludeFromComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;

//忽略使用  @ExcludeFromComponentScan 注解的类
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
@EnableFeignClients
@EnableEurekaClient
@RestController
@SpringBootApplication
public class ConsumerFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignHystrixApplication.class, args);
	}
}
