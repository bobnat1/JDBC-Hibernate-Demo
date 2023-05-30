package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionDAOImpl implements ConnectionDAO {
    @Override
    public boolean createTable() {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            t.commit();
            System.out.println("Successfully created table");
            session.close();
            factory.close();
            return true;
        }

        catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }

    @Override
    public boolean saveStudent(Student s) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.persist(s);
            Transaction t = session.beginTransaction();
            t.commit();
            System.out.println("Successfully added Student " + s);
            session.close();
            factory.close();
            return true;
        }

        catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }

    @Override
    public boolean saveCourse(Course c) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.persist(c);
            Transaction t = session.beginTransaction();
            t.commit();
            System.out.println("Successfully added Course " + c);
            session.close();
            factory.close();
            return true;
        }

        catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
}
