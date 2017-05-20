package com.book.service;

import com.book.entity.Teacher;

public interface TeacherService {
	
	Teacher login(String tid,String password,String role);
	
	Teacher findByid(String tid);
}
