package org.sba.test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceTest {
    @Test
    public void listAllCoursesTest() {
        List<Course> c = new ArrayList<>();
        CourseService testOne = new CourseService();
        c = testOne.getAllCourses();
        for (Course course: c) {
            System.out.println(course.getcName() + " | " + course.getcInstructorName() + " | " + course.getcId());
        }
    }
}
