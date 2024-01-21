package org.epam;

import org.epam.model.Address;
import org.epam.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Address address = Address.builder()
                .place("Pawani")
                .landmark("Near water tank")
                .pinCode("442304")
                .build();

        Student student = new Student();
        student.setFirstName("Jagdish");
        student.setLastName("Kamadi");
        student.setAddress(address);

        // open the transaction first
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        // save the data
        session.persist(student);
        // close the transaction
        tx.commit();
        session.close();

    }

    private static Session getSession() {
        // make the configuration first
        Configuration config = new Configuration()
                .configure("hiberante.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class);

        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();

        return sessionFactory.getCurrentSession();
    }

}
