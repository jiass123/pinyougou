package com.pinyougou.abstractfactory;

public class Test {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Course course = courseFactory.getCourse();
        Score score = courseFactory.getScore();
        course.play();
        score.play();
    }
}
