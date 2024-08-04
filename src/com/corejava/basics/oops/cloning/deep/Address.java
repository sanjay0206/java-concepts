package com.corejava.basics.oops.cloning.deep;

class Address implements Cloneable {
    String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person personCloned = (Person) super.clone();
        personCloned.address = (Address) address.clone(); // Deep clone the address
        return personCloned;
    }

    @Override
    public String toString() {
        return name + " lives in " + address;
    }
}

class DeepCloningExample {
    public static void main(String[] args) {
        try {
            Address address = new Address("New York", "USA");
            Person person1 = new Person("John", address);

            Person person2 = (Person) person1.clone();

            System.out.println(person1); // John lives in New York, USA
            System.out.println(person2); // John lives in New York, USA

            // Changing the address of person2
            person2.address.city = "Los Angeles";

            System.out.println(person1); // John lives in New York, USA
            System.out.println(person2); // John lives in Los Angeles, USA

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
