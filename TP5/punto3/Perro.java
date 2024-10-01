package TP5.punto3;

public class Perro implements Runnable{
    private Comedor comedor;
    public Perro (Comedor unCom) {
        this.comedor=unCom;
    }

    public void run() {
        try{
            comedor.comerPerro();
        } catch (Exception e){

        }
    }
}
