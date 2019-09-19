//package com.lambdaschool.school.service;
//
//import com.lambdaschool.school.SchoolApplicationTests;
//import com.lambdaschool.school.model.Course;
//import com.lambdaschool.school.model.Instructor;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SchoolApplicationTests.class)
//public class CourseServiceTest {
//
//    @Autowired
//    private CourseService courseService;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void findAll() {
//        assertEquals(6, courseService.findAll().size());
//    }
//
//    @Test
//    public void getCountStudentsInCourse() {
//    }
//
//    @Test
//    public void findCourseById() {
//        assertEquals("Data Science", courseService.findCourseById(1).getCoursename());
//    }
//
//    @Test
//    public void delete() {
//    }
//}