package com.asiainfo.builder;

public class Test {

    public static void main(String[] args) {
        Coach coach = new Coach(new CourseActualBuilder());
        Course java = coach.makeCourse("abc","bcd");
        System.out.println(java);
    }
}
