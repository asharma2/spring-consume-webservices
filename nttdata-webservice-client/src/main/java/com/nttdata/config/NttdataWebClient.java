package com.nttdata.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.nttdata.employees.GetEmployeeDetailsRequest;
import com.nttdata.employees.GetEmployeeDetailsResponse;

public class NttdataWebClient extends WebServiceGatewaySupport {

	public GetEmployeeDetailsResponse getEmployeeDetailsResponse(long id) {
		GetEmployeeDetailsRequest request = new GetEmployeeDetailsRequest();
		GetEmployeeDetailsResponse response = (GetEmployeeDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/spring-boot-tutorial-soap-web-services/ws/GetEmployeeDetails"));
		return response;
	}
	
	
	

}
