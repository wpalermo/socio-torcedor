package com.wpalermo.HystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class App 
{
	  public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	    }
	    
	    
}
