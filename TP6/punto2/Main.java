package TP6.punto2;

public class Main {
    public static void main(String[] args) {
        SalaEstudio sala=new SalaEstudio(5);
        Thread[] estudiantes=new Thread [20];

        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i]=new Thread(new Estudiante(sala));
            estudiantes[i].start();
        }
    }
}
