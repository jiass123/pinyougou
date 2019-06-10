package com.asiainfo.builder.line;

public class Test {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("java").buildCourseVideo("zhangsan").build();
        System.out.println(course);
    }
}
