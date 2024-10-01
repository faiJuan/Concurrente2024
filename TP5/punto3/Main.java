package TP5.punto3;

public class Main {
    public static void main(String[] args) {
        Comedor comedor=new Comedor(5);
        Thread[] perros= new Thread [20];
        Thread[] gatos= new Thread [20];
        GestorComedor controlador=new GestorComedor(comedor);
        Thread gestor=new Thread(controlador);

        for (int i = 0; i < gatos.length; i++) {
            gatos[i]=new Thread(new Gato(comedor));
            gatos[i].start();
        }

        for (int i = 0; i < perros.length; i++) {
            perros[i]=new Thread(new Perro(comedor));
            perros[i].start();
        }

        gestor.start();
        
    }
}
