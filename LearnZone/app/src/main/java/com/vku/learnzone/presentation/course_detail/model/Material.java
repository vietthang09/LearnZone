package com.vku.learnzone.presentation.course_detail.model;

public class Material {
    public int materialId;
    public String materialTitle;
    public String materialContent;
    public String fileName;

    public Material() {
    }

    public Material(int materialId, String materialTitle, String materialContent, String fileName) {
        this.materialId = materialId;
        this.materialTitle = materialTitle;
        this.materialContent = materialContent;
        this.fileName = fileName;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getMaterialContent() {
        return materialContent;
    }

    public void setMaterialContent(String materialContent) {
        this.materialContent = materialContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
