package com.company.practice2;

import by.gsu.pms.*;

public class Runner {
    public static void main(String[] args) {

        UniformMaterial wood = new UniformMaterial("oak", 2345);
        UniformMaterial steel = new UniformMaterial("steel", 7890);
        UniformMaterialSubject chair = new UniformMaterialSubject("chair", wood, 0.04);
        System.out.println(chair);

        chair.setUniformMaterial(steel);
        System.out.println("Mass is: " + chair.getMass());

        chair.setUniformMaterial(wood);
        System.out.println(chair);
    }
}
