package com.vku.learnzone.presentation.home.model;

public class Assignment {
    public int course_id;
    public String teacherAvatar;
    public String deadline;
    public String assignmentTitle;
    public String courseTitle;
    public int submission;

    public Assignment() {
    }

    public Assignment(int course_id, String teacherAvatar, String deadline, String assignmentTitle, String courseTitle, int submission) {
        this.course_id = course_id;
        this.teacherAvatar = teacherAvatar;
        this.deadline = deadline;
        this.assignmentTitle = assignmentTitle;
        this.courseTitle = courseTitle;
        this.submission = submission;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getSubmission() {
        return submission;
    }

    public void setSubmission(int submission) {
        this.submission = submission;
    }
}
