package com.company.guessNumber;

import java.util.Random;

public class RandomNumber {

    private static final Integer MAX=500;
    private static final Integer MIN=0;

    public static Integer getNumber(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(((MAX-MIN)+1)+MIN);
    }
}
