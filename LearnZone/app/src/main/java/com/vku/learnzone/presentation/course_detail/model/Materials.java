package com.vku.learnzone.presentation.course_detail.model;

import java.util.ArrayList;

public class Materials {
    private ArrayList<Material> materials;

    public Materials() {
    }

    public Materials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }
}


