package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            System.out.println("1. Class Info");
            System.out.println("Name: " + studentClass.getSimpleName());
            System.out.println("Package: " + studentClass.getPackageName());
            System.out.println("Superclass: " + studentClass.getSuperclass().getName());
            System.out.println("Interfaces: " + Arrays.toString(studentClass.getInterfaces()));
            System.out.println();

            System.out.println("2. Fields");
            for (Field field : studentClass.getDeclaredFields()) {
                System.out.printf("Name: %s | Type: %s | Modifiers: %s%n",
                        field.getName(),
                        field.getType().getSimpleName(),
                        Modifier.toString(field.getModifiers()));
            }
            System.out.println();

            System.out.println("3. Methods");
            for (Method method : studentClass.getDeclaredMethods()) {
                System.out.printf("Name: %s | Return: %s | Params: %s | Modifiers: %s%n",
                        method.getName(),
                        method.getReturnType().getSimpleName(),
                        Arrays.toString(method.getParameterTypes()),
                        Modifier.toString(method.getModifiers()));
            }
            System.out.println();

            System.out.println("4 & 5. Dynamic Instance & Public Call");
            Constructor<?> noArgConst = studentClass.getDeclaredConstructor();
            Object studentInstance = noArgConst.newInstance();

            Method sayHello = studentClass.getMethod("sayHello");
            sayHello.invoke(studentInstance);
            System.out.println();

            System.out.println("6. Access Private Field");
            Field nameField = studentClass.getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.println("Old name: " + nameField.get(studentInstance));
            nameField.set(studentInstance, "Razvan");
            System.out.println("New name: " + nameField.get(studentInstance));
            System.out.println();

            System.out.println("7. Invoke Private Method");
            Method privateMethod = studentClass.getDeclaredMethod("secretMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(studentInstance);
            System.out.println();

            System.out.println("8. Multiple Constructors");
            // Student(String name)
            Constructor<?> c1 = studentClass.getConstructor(String.class);
            Object s1 = c1.newInstance("Alice");

            // Student(String name, int age)
            Constructor<?> c2 = studentClass.getConstructor(String.class, int.class);
            Object s2 = c2.newInstance("Bob", 25);
            System.out.println("Created objects via specific constructors.");
            System.out.println(s1);
            System.out.println(s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}