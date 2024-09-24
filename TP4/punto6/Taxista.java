package TP4.punto6;

public class Taxista implements Runnable{
    private Recurso recu;
    public Taxista (Recurso recu1){
        this.recu=recu1;
    }

    public void run(){
        try {
            while(true){
                recu.taxista();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
