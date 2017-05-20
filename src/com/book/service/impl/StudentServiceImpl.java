package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.StudentDao;
import com.book.entity.Student;
import com.book.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student login(String sid, String password) {
		List<Student> list=studentDao.findByProperty2("sid", sid, "spassword", password);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}


}
