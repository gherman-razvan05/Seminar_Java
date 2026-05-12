package org.example;

public class Student {
    private String name;
    private int age;
    public String university;

    public Student() {
        this.name="";
        this.age=0;
        this.university="";
    }

    public Student(String name, int age, String university) {
        this.name = name;
        this.age = age;
        this.university=university;
    }

    public void sayHello() { System.out.println("Hello, my name is " + name + "."); }

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
