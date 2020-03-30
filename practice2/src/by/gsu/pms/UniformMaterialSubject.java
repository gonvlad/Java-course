package by.gsu.pms;

import java.awt.*;

public class UniformMaterialSubject {
    private UniformMaterial uniformMaterial;
    private String subjectName;
    private String subjectMaterial;
    private double subjectVolume;

    public UniformMaterialSubject() {}

    public UniformMaterialSubject(String subjectName, String subjectMaterial, double subjectVolume) {
        this.subjectName = subjectName;
        this.subjectMaterial = subjectMaterial;
        this.subjectVolume = subjectVolume;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectMaterial() {
        return subjectMaterial;
    }

    public double getSubjectVolume() {
        return subjectVolume;
    }

    public UniformMaterial getUniformMaterial() {
        return uniformMaterial;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectMaterial(String subjectMaterial) {
        this.subjectMaterial = subjectMaterial;
    }

    public void setSubjectVolume(double subjectVolume) {
        this.subjectVolume = subjectVolume;
    }

    public void setUniformMaterial(UniformMaterial uniformMaterial) {
        this.uniformMaterial = uniformMaterial;
    }

    public double getMass() {
        return uniformMaterial.getDensity() * subjectVolume;
    }

    public String toString() {
        return subjectName + ";" + uniformMaterial.getName() + ";" +
                uniformMaterial.getDensity() + ";" + subjectVolume + ";" + getMass();
    }
}
