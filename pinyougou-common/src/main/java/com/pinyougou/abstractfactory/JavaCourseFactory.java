package com.pinyougou.abstractfactory;

public class JavaCourseFactory implements CourseFactory{
    @Override
    public Course getCourse() {
        return new JavaCourse();
    }

    @Override
    public Score getScore() {
        return new JavaScore();
    }
}
