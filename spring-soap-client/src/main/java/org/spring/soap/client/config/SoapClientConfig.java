package org.spring.soap.client.config;

import org.spring.soap.client.article.ArticleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.spring.soap.article");
		return marshaller;
	}

	@Bean
	public ArticleClient articleClient(Jaxb2Marshaller marshaller) {
		ArticleClient client = new ArticleClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}
