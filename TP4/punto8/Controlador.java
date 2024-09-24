package TP4.punto8;

public class Controlador implements Runnable {
    private Produccion recurso;
    public Controlador (Produccion rec){
        this.recurso=rec;
    }

    public void run(){
        boolean terminar=false;
        while(!terminar){
            try {
                terminar=recurso.controlador();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
}
