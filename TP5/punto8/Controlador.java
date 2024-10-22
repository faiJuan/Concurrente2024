package TP5.punto8;

public class Controlador implements Runnable{
    private Soga soga;
    private boolean termino;
    public Controlador(Soga unaS) {
        this.soga=unaS;
        this.termino=false;
    }

    public void run (){
        while(!termino){
            try {
                termino=soga.controlador();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        soga.cruzaron();
        
    }
    
}
