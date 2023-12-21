package org.epam;

import org.apache.log4j.Logger;
import org.epam.model.Address;
import org.epam.model.Person;
import org.epam.model.Student;
import org.epam.ref.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This project is based on xml application in spring core
 * later on we discuss the about the annotation based project
 */
public class Main {

    //Apache log4 demo
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        This is the feature of java 10+version

        var context =
                new ClassPathXmlApplicationContext(new String[]{"propertybaseconfig.xml", "refconfig.xml", "constructorbaseconfig.xml"});


        LOGGER.info("\nSample log4j message\n");


        Student s1 = context.getBean("student1", Student.class);
        System.out.println(s1);
        Student s2 = context.getBean("student2", Student.class);
        System.out.println(s2);

        // for list,set and map type
        Address ad1 = context.getBean("myAddress", Address.class);
        System.out.println("\nMy Information");
        System.out.println(ad1.getId());
        System.out.println(ad1.getCurrentAddress());
        System.out.println(ad1.getPincode());
        System.out.println(ad1.getPhoneNumbers());


        // for the reference types
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println("\n" + employee);

        // constructor base config
        System.out.println("\nConstructor base bean");
        Person person = context.getBean("person2", Person.class);
        System.out.println(person);
        // checking for nested static class
        Person.RichPerson richPerson = context.getBean("richPerson", Person.RichPerson.class);
        System.out.println(richPerson);
    }
}

