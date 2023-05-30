package jpa.service;

import jpa.dao.ConnectionDAOImpl;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentDAO {
    @Override
    public List<Student> getAllStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Student";
        TypedQuery query = session.createQuery(hql);
        List<Student> results = query.getResultList();
        Transaction t = session.beginTransaction();
        t.commit();
        session.close();
        factory.close();

        return results;
    }

    @Override
    public Student getStudentByEmail(String email) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Student WHERE email =:email";
        TypedQuery<Student> query = session.createQuery(hql);
        query.setParameter("email", email);
        Student student  = query.getSingleResult();
        Transaction t = session.beginTransaction();
        t.commit();
        session.close();
        factory.close();

        return student;

    }

    @Override
    public boolean validateStudent(String email, String password) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            String hql = "FROM Student WHERE email =:email";
            TypedQuery<Student> query = session.createQuery(hql);
            query.setParameter("email", email);
            Student student = query.getSingleResult();

            if (student.getsPass().equals(password)) {
                return true;
            }
            return false;
        }
        catch(Exception e) {
            System.out.println("Wrong password and/or email");
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hqlOne = "FROM Course WHERE id =:id";
        TypedQuery query = session.createQuery(hqlOne);
        query.setParameter("id", cId);
        Course course = (Course) query.getSingleResult();
        System.out.println(course.getcName());

        Student student = getStudentByEmail(sEmail);
        System.out.println(student.getsName());

        List<Course> courseList = new ArrayList<>();
        courseList = getStudentCourses(sEmail);
        for (Course courses: courseList) {
            if (courses.getcId() == course.getcId()) {
                System.out.println("You are already registered in that course!");
                return;
            }
        }

        courseList.add(course);
        student.setsCourses(courseList);

        session.merge(student);
        Transaction t = session.beginTransaction();
        t.commit();
        session.close();
        factory.close();

    }

    @Override
    public List<Course> getStudentCourses(String email) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hqlOne = "FROM Student WHERE email =:email";
        TypedQuery query = session.createQuery(hqlOne);
        query.setParameter("email", email);
        Student student = (Student) query.getSingleResult();

        return student.getsCourses();
    }


}
