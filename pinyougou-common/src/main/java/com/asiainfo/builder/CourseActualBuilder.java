package com.asiainfo.builder;

public class CourseActualBuilder extends CourseBuilder{

    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        course.setCourseName(courseName);
    }

    @Override
    public void buildCourseVideo(String video) {
        course.setCourseVideo(video);
    }

    @Override
    public Course makeCourse(){
        return course;
    }
}
