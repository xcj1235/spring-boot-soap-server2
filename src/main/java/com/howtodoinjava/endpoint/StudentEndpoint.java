package com.howtodoinjava.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.domainobject.StudentDetailsRequest;
import com.howtodoinjava.domainobject.StudentDetailsResponse;
import com.howtodoinjava.service.StudentService;

@Endpoint
public class StudentEndpoint implements EndpointConstans {

	private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);

	@Autowired
	private StudentService studentService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = STUDENT_DETAILS_REQUEST)
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(studentService.getUsername(request));
		return response;
	}

}