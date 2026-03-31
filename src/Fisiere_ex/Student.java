package Fisiere_ex;

public class Student {

    private String name;
    private Integer age;
    private Specializare specializare;


    public Student() {
    }

    public Student(String name, Integer age, Specializare specializare) {
        this.name = name;
        this.age = age;
        this.specializare = specializare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", specializare=" + specializare +
                '}';
    }
}
