package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception {

        courseList = new ArrayList<>();

        Instructor i1 = new Instructor("Sally");
        i1.setInstructid(1);
        Instructor i2 = new Instructor("Lucy");
        i2.setInstructid(2);
        Instructor i3 = new Instructor("Charlie");
        i3.setInstructid(3);

//        instructrepos.save(i1);
//        instructrepos.save(i2);
//        instructrepos.save(i3);

        Course c1 = new Course("Data Science", i1);
        c1.setCourseid(1);
        Course c2 = new Course("JavaScript", i1);
        c2.setCourseid(2);
        Course c3 = new Course("Node.js", i1);
        c3.setCourseid(3);
        Course c4 = new Course("Java Back End", i2);
        c4.setCourseid(4);
        Course c5 = new Course("Mobile IOS", i2);
        c5.setCourseid(5);
        Course c6 = new Course("Mobile Android", i3);
        c6.setCourseid(6);
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
        courseList.add(c5);
        courseList.add(c6);



//        c1 = courseService.save(c1);
//        c2 = courseService.save(c2);
//        c3 = courseService.save(c3);
//        c4 = courseService.save(c4);
//        c5 = courseService.save(c5);
//        c6 = courseService.save(c6);

        Student s1 = new Student("John");
        s1.getCourses().add(courseService.findCourseById(c1.getCourseid()));
        s1.getCourses().add(courseService.findCourseById(c4.getCourseid()));

        Student s2 = new Student("Julian");
        s2.getCourses().add(courseService.findCourseById(c2.getCourseid()));
        Student s3 = new Student("Mary");
        s3.getCourses().add(courseService.findCourseById(c3.getCourseid()));
        s3.getCourses().add(courseService.findCourseById(c1.getCourseid()));
        s3.getCourses().add(courseService.findCourseById(c6.getCourseid()));
//
//        studentService.save(s1);
//        studentService.save(s2);
//        studentService.save(s3);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() throws Exception {
        String apiUrl = "/courses/courses";

        Mockito.when(courseService.findAll()).thenReturn((ArrayList<Course>) courseList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(courseList);

        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void getCountStudentsInCourses() {
    }

    @Test
    public void deleteCourseById() {
    }
}