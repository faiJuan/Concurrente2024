package TP4.punto6;

public class Pasajero implements Runnable{
    private Recurso recu;
    public Pasajero (Recurso recu1){
        this.recu=recu1;
    }

    public void run(){
        try {
            while(true){
                recu.usarTaxi();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
