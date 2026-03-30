package Collections_ex;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade,other.grade);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return getGrade() == student.getGrade() && Objects.equals(getName(), student.getName());
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return getGrade() == student.getGrade() && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGrade());
    }
}
