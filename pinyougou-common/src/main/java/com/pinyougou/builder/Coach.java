package com.pinyougou.builder;

public class Coach {

    private CourseBuilder courseBuilder;

    public Coach(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName,String video){
        courseBuilder.buildCourseVideo(courseName);
        courseBuilder.buildCourseVideo(video);
        return courseBuilder.makeCourse();
    }
}
