package TP5.punto3;

public class Gato implements Runnable{
    private Comedor comedor;
    public Gato (Comedor unCom){
        this.comedor=unCom;
    }

    public void run() {
        try{
            comedor.empezarComerGato();
            /*Thread.sleep(2000);
            comedor.terminoGato();*/
        } catch (Exception e){

        }
    }
}
