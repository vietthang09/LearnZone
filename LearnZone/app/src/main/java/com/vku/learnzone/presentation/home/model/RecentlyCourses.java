package com.vku.learnzone.presentation.home.model;

import java.util.ArrayList;

public class RecentlyCourses {
    private ArrayList<RecentlyCourse> recentlyCourses;

    public RecentlyCourses() {
    }

    public RecentlyCourses(ArrayList<RecentlyCourse> recentlyCourses) {
        this.recentlyCourses = recentlyCourses;
    }

    public ArrayList<RecentlyCourse> getRecentlyCourses() {
        return recentlyCourses;
    }

    public void setRecentlyCourses(ArrayList<RecentlyCourse> recentlyCourses) {
        this.recentlyCourses = recentlyCourses;
    }
}
