package org.example;

public class Student {
    private String name;
    private int age;
    public String university = "ASE";

    public Student() {
        this.name = "Default";
        this.age = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + ".");
    }

    private void secretMethod() {
        System.out.println("This is a private method.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", university='" + university + '\'' +
                '}';
    }
}
