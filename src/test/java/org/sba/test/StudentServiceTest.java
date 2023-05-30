package org.sba.test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceTest {
    @Test
    public void listAllStudentsTest() {
        List<Student> s = new ArrayList<>();
        StudentService testOne = new StudentService();
        s = testOne.getAllStudents();
        int size = s.size();
        for (Student student: s) {
            System.out.println(student.getsName() + " | " + student.getsEmail());
        }
    }
    @Test
    public void getStudentByEmailTest() {
        StudentService testTwo = new StudentService();
        Student s2 = testTwo.getStudentByEmail("sbowden1@yellowbook.com");
        System.out.println(s2);
    }
    @Test
    public void validateStudentTest() {
        StudentService testThree = new StudentService();
        Assertions.assertTrue(testThree.validateStudent("sbowden1@yellowbook.com", "SJc4aWSU"));
    }
    @Test
    public void getStudentCoursesTest() {
        List<Course> sc = new ArrayList<>();
        StudentService testFour = new StudentService();
        sc = testFour.getStudentCourses("hluckham0@google.ru");
        for (Course course: sc) {
            System.out.println(course.getcName());
        }
    }

    @Test
    public void registerStudentTest() {
        StudentService testSix = new StudentService();
        testSix.registerStudentToCourse("sbowden1@yellowbook.com", 2);
    }
}
