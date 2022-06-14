package com.vku.learnzone.presentation.course_detail.model;

import java.util.ArrayList;

public class Assignments {
    private ArrayList<Assignment> assignments;

    public Assignments() {
    }

    public Assignments(ArrayList<Assignment> assignmentArrayList) {
        this.assignments = assignmentArrayList;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }
}
