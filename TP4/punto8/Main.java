package TP4.punto8;

public class Main {
    public static void main(String[] args) {
        Thread[] electricos=new Thread [15];
        Thread[] mecanicos=new Thread [15];
        Produccion cintas=new Produccion();
        Thread controlador=new Thread(new Controlador(cintas));


        for (int i = 0; i < electricos.length; i++) {
            electricos[i]=new Thread (new ProductoElectrico(cintas));
            electricos[i].start();
        }

        for (int i = 0; i < mecanicos.length; i++) {
            mecanicos[i]=new Thread (new ProductoMecanico(cintas));
            mecanicos[i].start();
        }
        controlador.start();

    }
}
