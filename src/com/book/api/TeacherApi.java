package com.book.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.book.entity.Teacher;
import com.book.service.TeacherService;

@Controller
@Path("/teacher")
public class TeacherApi {

	@Autowired
	private TeacherService teacherService;
	
	@GET
	@Path("/findByid/{id}")
    @Consumes("application/json;charset=UTF-8")
	public Teacher findByid(@PathParam("id") String tid){
		return teacherService.findByid(tid);
	}
}
