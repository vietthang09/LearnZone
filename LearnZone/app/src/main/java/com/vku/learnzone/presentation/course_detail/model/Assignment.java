package com.vku.learnzone.presentation.course_detail.model;

public class Assignment {
    public String teacherAvatar;
    public int assignmentId;
    public String assignmentTitle;
    public String deadline;
    public String courseTitle;
    public int submission;

    public Assignment() {
    }

    public Assignment(String teacherAvatar, int assignmentId, String assignmentTitle, String deadline, String courseTitle, int submission) {
        this.teacherAvatar = teacherAvatar;
        this.assignmentId = assignmentId;
        this.assignmentTitle = assignmentTitle;
        this.deadline = deadline;
        this.courseTitle = courseTitle;
        this.submission = submission;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
