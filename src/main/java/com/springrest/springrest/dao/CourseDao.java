package com.springrest.springrest.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long>{




}
