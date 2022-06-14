package com.vku.learnzone.presentation.courses.model;

import java.util.ArrayList;

public class Courses {
    private ArrayList<Course> courses;

    public Courses() {
    }

    public Courses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
