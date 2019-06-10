package com.asiainfo.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student {

    private String name;


    private int age;

    private Gender gender;

    private Grade grade;

    public Student(String name, int age, Gender gender, Grade grade) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", age=" + age + ", gender=" + gender
                + ", grade=" + grade + "]";
    }

}

enum Gender {
    MALE, FEMALE
}

enum Grade {
    ONE, TWO, THREE, FOUR;
}

public class CollectDemo {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("a", 10, Gender.MALE, Grade.ONE),
                new Student("b", 9, Gender.MALE, Grade.THREE),
                new Student("c", 8, Gender.FEMALE, Grade.TWO),
                new Student("d", 13, Gender.FEMALE, Grade.FOUR),
                new Student("e", 7, Gender.FEMALE, Grade.THREE),
                new Student("f", 13, Gender.MALE, Grade.ONE),
                new Student("g", 13, Gender.FEMALE, Grade.THREE),
                new Student("h", 9, Gender.FEMALE, Grade.TWO),
                new Student("j", 6, Gender.MALE, Grade.ONE),
                new Student("k", 6, Gender.MALE, Grade.ONE),
                new Student("l", 14, Gender.FEMALE, Grade.FOUR),
                new Student("m", 13, Gender.MALE, Grade.FOUR));
        List<Integer> collect =
                // 将集合转换为流
                students.stream()
                        // 取出每一个学生的年龄
                        .map(Student::getAge)
                        // 将这些年龄收集为集合
                        .collect(Collectors.toList());
        System.out.println(collect);

        IntSummaryStatistics collect1 =
                // 将集合转化为流
                students.stream()
                        // 获取集合中的数字值 并进行汇总
                        .collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(collect1);


        Map<Boolean, List<Student>> collect2 =
                // 将集合转化为流
                students.stream()
                        // 根据性别进行分块 等于 true 的为一组 false 的为一组
                        .collect(Collectors.partitioningBy(student -> student.getGender() == Gender.MALE));
        System.out.println(collect2);

        Map<Grade, List<Student>> collect3 =
                // 将集合转换为流
                students.stream()
                        // 根据班级进行分组
                        .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println(collect3);

    }

}
