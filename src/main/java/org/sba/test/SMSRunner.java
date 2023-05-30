package org.sba.test;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Run ConnectionDAOTest before starting runner to populate database
public class SMSRunner
{
    public static void main( String[] args )
    {
        do {
            Scanner scan = new Scanner(System.in);

            System.out.println("Are you a(n)\n1. Student \n2. quit ");
            int answerOne = Integer.parseInt(scan.nextLine());
            if (answerOne == 2)
                break;

            else if (answerOne == 1) {
                System.out.println("Enter your email ");
                String email = scan.nextLine();
                System.out.println("Enter your Password ");
                String password = scan.nextLine();

                StudentService studentService = new StudentService();
                boolean validate = studentService.validateStudent(email, password);
                if (validate) {
                    List<Course> courseList;
                    courseList = studentService.getStudentCourses(email);

                    System.out.println("COURSE ID | COURSE NAME | INSTRUCTOR NAME");
                    for (Course c: courseList) {
                        System.out.println("Current Classes: " + c.getcId()+ " | " + c.getcName() + " | " + c.getcInstructorName());
                    }
                } else
                    continue;

                System.out.println("1. Register to class\n2. Logout");
                int answerTwo = Integer.parseInt(scan.nextLine());

                if (answerTwo == 2) {
                    System.out.println("Logging out");
                    break;
                }
                if (answerTwo == 1) {
                    CourseService courseService = new CourseService();
                    List<Course> courseListTwo;
                    courseListTwo = courseService.getAllCourses();
                    for (Course cl : courseListTwo) {
                        System.out.println(cl.getcId() + " | " + cl.getcInstructorName() + " | " + cl.getcName());
                    }
                }
                else
                    continue;

                System.out.println("Which Course ");
                int answerThree = Integer.parseInt(scan.nextLine());
                studentService.registerStudentToCourse(email, answerThree);

                System.out.println("Your classes: ");
                List<Course> courseListThree;
                courseListThree = studentService.getStudentCourses(email);
                for (Course c: courseListThree) {
                    System.out.println("Current Classes: " + c.getcId()+ " | " + c.getcName() + " | " + c.getcInstructorName());
                }

                System.out.println("Logging out");
                break;

            }

        } while (true);
    }
}
