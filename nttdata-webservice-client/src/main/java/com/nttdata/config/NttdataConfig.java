package com.nttdata.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@Configuration
public class NttdataConfig {

	@Bean
	public ServletRegistrationBean<?> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
//		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
	}

	@Bean(name = "employees")
	public SimpleWsdl11Definition defaultWsdl11Definition() {
		SimpleWsdl11Definition definition = new SimpleWsdl11Definition();
		definition.setWsdl(new ClassPathResource("employee.wsdl"));
		return definition;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.nttdata.employees");
		return marshaller;
	}

	@Bean
	public NttdataWebClient nttdataWebClient(Jaxb2Marshaller marshaller) {
		NttdataWebClient client = new NttdataWebClient();
		client.setDefaultUri("http://localhost:8080/nttdata/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
