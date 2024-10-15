package TP5.punto8;

public class Babuino implements Runnable{
    private Soga soga;
    private char lado;
    public Babuino(Soga unaS,char unLado){
        this.soga=unaS;
        this.lado=unLado;
    }


    public void run (){
        try {
            if(lado=='A'){
                soga.cruzarLadoA(lado);
                Thread.sleep(2000);
                soga.terminarA();
                lado='B';
            }else{
                soga.cruzarLadoB(lado);
                Thread.sleep(2000);
                soga.terminarB();
                lado='A';
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
