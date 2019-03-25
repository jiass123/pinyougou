package com.pinyougou.builder;

public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);

    public abstract void buildCourseVideo(String video);

    public abstract Course makeCourse();
}
