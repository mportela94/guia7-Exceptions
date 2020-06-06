package com.company;

import com.company.guessNumber.Game;
import com.company.guessNumber.RandomNumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game juego = new Game();
        while (juego.getHit() == false){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngrese un numero:");
            String string=scanner.nextLine();
            juego.userAttempt(string);
        }
        System.out.println("\nFelicitaciones, ganaste el juego, el numero era: " + juego.getNumber());
        System.out.println("\nCantidad de intentos: " + juego.getIntentos());

    }
}
