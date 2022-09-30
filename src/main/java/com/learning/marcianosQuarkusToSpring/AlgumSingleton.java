package com.learning.marcianosQuarkusToSpring;

public class AlgumSingleton {

    private static AlgumSingleton instancia;

    private AlgumSingleton() {

    }


    public static AlgumSingleton getInstance() {
        if (instancia == null) {
            instancia = new AlgumSingleton();
        }
        return instancia;
    }

}
