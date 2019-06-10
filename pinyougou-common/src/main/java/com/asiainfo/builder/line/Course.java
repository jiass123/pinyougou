package com.pinyougou.builder.line;

public class Course {

    private String courseName;
    private String courseVideo;

    public Course(CourseBuilder courseBuilder){
        this.courseName = courseBuilder.courseName;
        this.courseVideo = courseBuilder.courseVideo;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                '}';
    }

    public static class CourseBuilder{

        private String courseName;
        private String courseVideo;

        public CourseBuilder buildCourseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo){
            this.courseVideo = courseVideo;
            return this;
        }

        public Course build(){
            return new Course(this);
        }
    }
}
