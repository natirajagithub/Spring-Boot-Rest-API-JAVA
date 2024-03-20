package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.entities.Course;


@RestController
@RequestMapping("api/courses")
public class MyController {
	@Autowired
	com.springrest.springrest.services.CourseServiceImpl CourseServiceImpl;
	
	@Autowired
	private CourseService courseService;
	
	
	//Get the Courses
		@GetMapping("/course")
		public List<Course>getCourses(){
			
			return this.courseService.getCourses();
		}
		
		
		//Get Data By ID
		
		@GetMapping("/courses/{courseId}")
		public Course getCourse(@PathVariable long courseId){
			
			return CourseServiceImpl.getCourse(courseId);
		}
		
		
		// Add new courses
		@PostMapping("/courses")
		public Course addCourse(@RequestBody Course course){
			return this.courseService.addCourse(course);
		}
		
		// Update Data
		
		@PutMapping("courses")
		public Course updateCourse(@RequestBody Course course) {
			return this.courseService.updateCourse(course);
		}
		
		
		// Delete data
		@DeleteMapping("courses/{courseId}")
		public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
			try {
				this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
	
	
		
	}
		

