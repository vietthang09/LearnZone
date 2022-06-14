package com.vku.learnzone.presentation.home.model;

import java.util.ArrayList;

public class Assignments {

    private ArrayList<Assignment> assignments;

    public Assignments() {
    }

    public Assignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }
}
