package org.epam.model;

public class Person {
    private Integer personId;
    private String personName;
    private Car car;

    public Person() {
    }

    public Person(Integer personId, String personName, Car car) {
        this.personId = personId;
        this.personName = personName;
        this.car = car;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", car=" + car +
                '}';
    }

    public static class RichPerson {
        private String personName;

        public RichPerson(String personName) {
            this.personName = personName;
        }

        @Override
        public String toString() {
            return "RichPerson{" +
                    "personName='" + personName + '\'' +
                    '}';
        }
    }
}
