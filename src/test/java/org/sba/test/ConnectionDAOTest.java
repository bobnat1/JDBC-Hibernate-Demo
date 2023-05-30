package org.sba.test;

import jpa.dao.ConnectionDAOImpl;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Run Tests before main method to set up database
public class ConnectionDAOTest {
    @Test
    public void createTableTest(){
        ConnectionDAOImpl con1 = new ConnectionDAOImpl();
        assertTrue(con1.createTable());
    }

    @Test
    public void insertStudentTest() {
        ConnectionDAOImpl con2 = new ConnectionDAOImpl();

        Student studentOne = new Student();
        studentOne.setsEmail("hluckham0@google.ru");
        studentOne.setsName("Hazel Luckham");
        studentOne.setsPass("X1uZcoIh0dj");

        Student studentTwo = new Student();
        studentTwo.setsEmail("sbowden1@yellowbook.com");
        studentTwo.setsName("Sonnnie Bowden");
        studentTwo.setsPass("SJc4aWSU");

        Student studentThree = new Student();
        studentThree.setsEmail("qllorens2@howstuffworks.com");
        studentThree.setsName("Quillan Llorens");
        studentThree.setsPass("W6rJuxd");

        Student studentFour = new Student();
        studentFour.setsEmail("cstartin3@flickr.com");
        studentFour.setsName("Clem Startin");
        studentFour.setsPass("XYHzJ1S");

        Student studentFive = new Student();
        studentFive.setsEmail("tattwool4@biglobe.ne.jp");
        studentFive.setsName("Thornie Attwool");
        studentFive.setsPass("Hjt0SoVmuBz");

        Student studentSix = new Student();
        studentSix.setsEmail("hguerre5@deviantart.com");
        studentSix.setsName("Harcourt Guerre");
        studentSix.setsPass("OzcxzD1PGs");

        Student studentSeven = new Student();
        studentSeven.setsEmail("htaffley6@columbia.edu");
        studentSeven.setsName("Holmes Taffley");
        studentSeven.setsPass("xowtOQ");

        Student studentEight = new Student();
        studentEight.setsEmail("aiannitti7@is.gd");
        studentEight.setsName("Alexandra Iannitti");
        studentEight.setsPass("TWP4hf5j");

        Student studentNine = new Student();
        studentNine.setsEmail("ljiroudek8@sitemeter.com");
        studentNine.setsName("Laryssa Jiroudek");
        studentNine.setsPass("bXRoLUP");

        Student studentTen = new Student();
        studentTen.setsEmail("cjaulme9@bing.com");
        studentTen.setsName("Cahra Jaulme");
        studentTen.setsPass("FnVklVgC6r6");
        assertAll("Multiple assertions of inserting Students",
                () -> assertTrue(con2.saveStudent(studentOne)),
                () -> assertTrue(con2.saveStudent(studentTwo)),
                () -> assertTrue(con2.saveStudent(studentThree)),
                () -> assertTrue(con2.saveStudent(studentFour)),
                () -> assertTrue(con2.saveStudent(studentFive)),
                () -> assertTrue(con2.saveStudent(studentSix)),
                () -> assertTrue(con2.saveStudent(studentSeven)),
                () -> assertTrue(con2.saveStudent(studentEight)),
                () -> assertTrue(con2.saveStudent(studentNine)),
                () -> assertTrue(con2.saveStudent(studentTen)));

    }

    @Test
    public void insertCourseTest() {
        ConnectionDAOImpl con3 = new ConnectionDAOImpl();

        Course courseOne = new Course();
        courseOne.setcId(1);
        courseOne.setcName("English");
        courseOne.setcInstructorName("Anderea Scamaden");

        Course courseTwo = new Course();
        courseTwo.setcId(2);
        courseTwo.setcName("Mathematics");
        courseTwo.setcInstructorName("Eustace Niemetz");

        Course courseThree = new Course();
        courseThree.setcId(3);
        courseThree.setcName("Anatomy");
        courseThree.setcInstructorName("Reynolds Pastor");

        Course courseFour = new Course();
        courseFour.setcId(4);
        courseFour.setcName("Organic Chemistry");
        courseFour.setcInstructorName("Odessa Belcher");

        Course courseFive = new Course();
        courseFive.setcId(5);
        courseFive.setcName("Physics");
        courseFive.setcInstructorName("Dani Swallow");

        Course courseSix = new Course();
        courseSix.setcId(6);
        courseSix.setcName("Digital Logic");
        courseSix.setcInstructorName("Glenden Reilingen");

        Course courseSeven = new Course();
        courseSeven.setcId(7);
        courseSeven.setcName("Object Oriented Programming");
        courseSeven.setcInstructorName("Giselle Ardy");

        Course courseEight = new Course();
        courseEight.setcId(8);
        courseEight.setcName("Data Structures");
        courseEight.setcInstructorName("Carolan Stoller");

        Course courseNine = new Course();
        courseNine.setcId(9);
        courseNine.setcName("Politics");
        courseNine.setcInstructorName("Carmita De Maine");

        Course courseTen = new Course();
        courseTen.setcId(10);
        courseTen.setcName("Art");
        courseTen.setcInstructorName("Kingsly Doxsey");

        assertAll("Multiple assertions of inserting Students",
                () -> assertTrue(con3.saveCourse(courseOne)),
                () -> assertTrue(con3.saveCourse(courseTwo)),
                () -> assertTrue(con3.saveCourse(courseThree)),
                () -> assertTrue(con3.saveCourse(courseFour)),
                () -> assertTrue(con3.saveCourse(courseFive)),
                () -> assertTrue(con3.saveCourse(courseSix)),
                () -> assertTrue(con3.saveCourse(courseSeven)),
                () -> assertTrue(con3.saveCourse(courseEight)),
                () -> assertTrue(con3.saveCourse(courseNine)),
                () -> assertTrue(con3.saveCourse(courseTen)));
    }
}
