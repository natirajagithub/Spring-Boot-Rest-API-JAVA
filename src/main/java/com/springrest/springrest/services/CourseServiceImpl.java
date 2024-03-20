package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;



@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	
	
	private CourseDao courseDao;

	
	public CourseServiceImpl() {
		
//		list=new ArrayList<>();
//		list.add(new Course(145, "java", "Success"));
//		list.add(new Course(4343, "java","Success"));
//		
		
	}
	    public Course getCour(long courseId){
		 
	    return courseDao.getById(courseId);
	    }

	

	@Override
	public Course addCourse(Course course) {

	return courseDao.save(course);
	
}


@Override
public Course updateCourse(Course course) {

	courseDao.save(course);
	return course;
	}



@Override
public void deleteCourse(Long parseLong) {
	
	Course entity=courseDao.getOne(parseLong);
	courseDao.delete(entity);
    }




@Override
public List<Course> getCourses() {
	// TODO Auto-generated method stub
	return courseDao.findAll();
}
@Override
public Course getCourse(long courseId) {
	// TODO Auto-generated method stub
	return null;
}


//
//
//@Override
//public Course getCourse(long courseId) {
//	// TODO Auto-generated method stub
//	return null;
//}

}

