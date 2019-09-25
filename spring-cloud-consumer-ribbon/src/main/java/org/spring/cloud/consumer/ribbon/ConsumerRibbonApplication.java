package org.spring.cloud.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// 指定 spring-cloud-provider 服务使用 LoadBalancedConfig 提供的策在均衡的策略
@RibbonClient(name = "spring-cloud-provider", configuration = org.spring.cloud.consumer.config.LoadBalancedConfig.class)
@EnableEurekaClient
@RestController
@SpringBootApplication
public class ConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/info")
	public String info() {
		return restTemplate.getForObject("http://spring-cloud-provider/info", String.class);
	}

}
