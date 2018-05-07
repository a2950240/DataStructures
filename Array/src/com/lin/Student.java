package com.lin;

/**
 * Created by l on 2018/5/6.
 */
public class Student {
    private String name;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",66));
        arr.addLast(new Student("Charlie",88));
        System.out.println(arr);
    }
}
