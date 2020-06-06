package com.company.guessNumber;

public class Game {

    public Integer intentos;
    public Integer number;
    private static boolean hit;

    public Game(){
        this.intentos=0;
        this.number=RandomNumber.getNumber();
        this.hit=false;
    }

    public Integer getNumber(){
        return number;
    }

    public boolean getHit(){
        return hit;
    }

    public Integer getIntentos(){
        return intentos;
    }

    public boolean comparaNumeros(Integer numero){
        int i=number.compareTo(numero);
        if (i==0){
            hit=true;
        }else if(i==-1){
            hit=false;
            System.out.println("\nEl numero es menor.");
        }else if (i==1){
            hit=false;
            System.out.println("\nEl numero es mayor.");
        }
        return hit;
    }

    public boolean userAttempt(String string){
        boolean flag=false;
        intentos++;
        try{
            Integer numero= Integer.parseInt(string);      //parseInt(String s) throws NumberFormatException si el string no es un numero
            flag=true;
            this.hit=comparaNumeros(numero);
        }catch (NumberFormatException exception){
            flag=false;
            exception.printStackTrace();
        }finally {
        }
        return flag;
    }
}
