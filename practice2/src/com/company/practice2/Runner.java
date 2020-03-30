package com.company.practice2;

import by.gsu.pms.*;

public class Runner {
    public static void main(String[] args) {
        UniformMaterialSubject wire = new UniformMaterialSubject();

        UniformMaterial STEEL = UniformMaterial.STEEL;
        wire.setSubjectName("wire");
        wire.setUniformMaterial(STEEL);
        wire.setSubjectVolume(0.03);
        System.out.println(wire);

        UniformMaterial COPPER = UniformMaterial.COPPER;
        wire.setUniformMaterial(COPPER);

        System.out.println("Mass is: " + wire.getMass());

        wire.setUniformMaterial(STEEL);
        System.out.println(wire);
    }
}
