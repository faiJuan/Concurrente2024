package TP2.punto6;

public class Corredor implements Runnable {
    private int nombre;

    private int distancia = 0;

    public Corredor(int unNombre) {
        this.nombre = unNombre;
    }

    public int distanciaTotal() {
        return distancia;
    }

    public void run() {
        int avance = 0;
        int pasos=0;
        while (pasos <= 100) {
            avance = (int) (Math.random() * 10);
            distancia = distancia + avance;
            pasos++;
            System.out.println(this.nombre+ " avanzo " + avance + " metros");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + " recorrido" + distancia);
    }

    
}
