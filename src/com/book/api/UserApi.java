package com.book.api;



import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.book.entity.Student;
import com.book.entity.Teacher;
import com.book.service.StudentService;
import com.book.service.TeacherService;

import static com.book.util.Args.TokenStudent;
import static com.book.util.Args.TokenTeacher;
import static com.book.util.Args.TokenTime;
import static com.book.util.Trans.MD5;

@Path("/user")
@Controller
public class UserApi  {
	@Autowired
    private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	

	 @GET
	 @Path("/Stuau={au}")
	 @Consumes("application/json;charset=UTF-8")
	 public Student getByAU(@PathParam("au")String au){
	        return TokenStudent.get(au);
	 }
	 
	

	
	@POST
	@Path("/Stulogin")
	public String getStuToken(@FormParam("username")String sid,
			@FormParam("password")String password) throws Exception {
		
		Student s = studentService.login(sid, password);
		
        if(s==null){
            return null;
        }else{
            Long time = System.currentTimeMillis()/1000;
            String token = MD5(sid+password+String.valueOf(time));
            if(null == TokenTime){
                TokenTime = new HashMap<>();
            }
            TokenTime.put(token,time);
            if(null == TokenStudent){
            	TokenStudent = new HashMap<>();
            }
            TokenStudent.put(token,s);
            return token;
        }
    }
	
	 @GET
	 @Path("/Teaau={au}")
	 @Consumes("application/json;charset=UTF-8")
	 public Teacher getByA(@PathParam("au")String au){
	        return TokenTeacher.get(au);
	 }
	 
	 
	@POST
	@Path("/Tealogin/{role}")
	public String getTeaToken(@FormParam("username")String tid,
			@FormParam("password")String password,
			@PathParam("role") String role) throws Exception {
		
		Teacher t= teacherService.login(tid, password, role);
		
        if(t==null){
            return null;
        }else{
            Long time = System.currentTimeMillis()/1000;
            String token = MD5(tid+password+String.valueOf(time));
            if(null == TokenTime){
                TokenTime = new HashMap<>();
            }
            TokenTime.put(token,time);
            if(null == TokenStudent){
            	TokenTeacher = new HashMap<>();
            }
            TokenTeacher.put(token,t);
      
            return token;
        }
    }
	
}
