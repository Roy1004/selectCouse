package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.TeacherDao;
import com.book.entity.Teacher;
import com.book.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Teacher login(String tid, String password,String role) {
		List<Teacher> list=
	    	teacherDao.findByProperty3("tid", tid, "tpassword", password,"power", role);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Teacher findByid(String tid) {
		//(Teacher) teacherDao.findByProperty("tid",tid).get(0);
		return  teacherDao.findById(tid);
	}

}
