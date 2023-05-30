package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {
    @Override
    public List<Course> getAllCourses() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Course";
        TypedQuery query = session.createQuery(hql);
        List<Course> results = query.getResultList();
        Transaction t = session.beginTransaction();
        t.commit();
        session.close();
        factory.close();

        return results;

    }
}
