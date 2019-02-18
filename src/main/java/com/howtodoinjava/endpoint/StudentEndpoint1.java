package com.howtodoinjava.endpoint;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ObjectUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.domainobject.StudentDetailsRequest1;
import com.howtodoinjava.domainobject.StudentDetailsResponse1;
import com.howtodoinjava.service.StudentService1;

@Endpoint
public class StudentEndpoint1 implements EndpointConstans {
	private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint1.class);

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = STUDENT_DETAILS_REQUEST_1)
	@ResponsePayload
	public StudentDetailsResponse1 getStudent(@RequestPayload StudentDetailsRequest1 request1) throws SOAPException {
		StudentDetailsResponse1 response1 = new StudentDetailsResponse1();

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentService1 service = context.getBean("StudentService1", StudentService1.class);

		response1.setStudent1(service.getUsername1(request1));
//		if (ObjectUtils.isEmpty(request1.getName1())) {
//			SOAPFault fault;
//			fault = SOAPFactory.newInstance().createFault();
//			fault.setFaultString("400");
//			throw new SOAPFaultException(fault);
//
//		}
//		if (ObjectUtils.isEmpty(response1.getStudent1())) {
//			SOAPFault fault;
//			fault = SOAPFactory.newInstance().createFault();
//			fault.setFaultString("500");
//			throw new SOAPFaultException(fault);
//		}
		return response1;
	}
}