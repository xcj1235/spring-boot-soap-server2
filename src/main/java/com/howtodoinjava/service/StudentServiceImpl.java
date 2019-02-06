package com.howtodoinjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.howtodoinjava.domainobject.Student;
import com.howtodoinjava.domainobject.StudentDetailsRequest;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository repository;

	@Override
	public Student getUsername(StudentDetailsRequest req) {
		Assert.notNull(req.getName(), "The Student's name must not be null");
		logger.info(req.getName() + "-----------StudentServiceImpl----------");
		return repository.findStudent(req);
	}
}
