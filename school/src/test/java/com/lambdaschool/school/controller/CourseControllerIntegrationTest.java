package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import com.lambdaschool.school.service.InstructorService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //set up web environment for random port
public class CourseControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private InstructorService instructorService;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    // GET /courses/courses/
    @Test
    public void measuredResponseTime() {
        given().when().get("/courses/courses").then().time(lessThan(5000L));
    }

    // POST /courses/course/add
    @Test
    public void addNewCourse() throws Exception {
//
        String apiUrl = "/courses/course/add";
//
//        String newCourseName = "Test";
//        Course newCourse = new Course(newCourseName);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String rt = mapper.writeValueAsString(newCourse);
//
//        Mockito.when(courseService.save())

        String courseName =  "Test Course";
        Instructor s1 = instructorService.findInstructorById(1);
        Course c7 = new Course("Backend", s1);

        ObjectMapper mapper = new ObjectMapper();
        String mapToString = mapper.writeValueAsString(c7);

        given().contentType("application/json").body(mapToString).when().post(apiUrl).then().statusCode(201);
    }

}
