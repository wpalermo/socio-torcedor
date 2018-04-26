package com.wpalermo.socioTorcedor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@Configuration
public class MongoConfiguration {
	
    @Bean
    public MongoClient mongoClient() {
    	MongoClientURI mongoUri = new MongoClientURI("mongodb+srv://admin:admin@clustersociotorcedor-txdbj.mongodb.net/test");
    	return new MongoClient(mongoUri);
    }
    
    
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "socioTorcedor-db");
    }

}
