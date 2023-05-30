package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface ConnectionDAO {
    //TODO add connection to database here implemented as a method
    boolean createTable();
    boolean saveStudent(Student s);
    boolean saveCourse(Course c);
}
