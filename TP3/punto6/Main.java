package TP3.punto6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int suma [] = new int [50];
        for (int i = 0; i < 50; i++) {
            suma[i]= new Random().nextInt(10)+1;
        }
    }
}

