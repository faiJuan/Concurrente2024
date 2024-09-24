package TP4.punto7;

public class Mozo implements Runnable{
    Silla recurso;
    public Mozo (Silla rec){
        this.recurso=rec;
    }    

    public void run (){
        while(true){
            try {
                recurso.prepararComida();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
