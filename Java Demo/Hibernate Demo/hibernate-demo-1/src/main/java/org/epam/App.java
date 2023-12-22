package org.epam;

import org.epam.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Jagdish");
        student.setLastName("Kamadi");

        // make the configuration first
        Configuration config = new Configuration()
                .configure("hiberante.cfg.xml")
                .addAnnotatedClass(Student.class);

        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        // open the transaction firs
        Transaction tx = session.beginTransaction();
        session.persist(student);

        // close the transaction
        tx.commit();
        // close the session
        session.close();

    }
}
