package TP7.punto2;

public class Programador implements Runnable{
    private Coordinador estudio;
    private int valor;

    public Programador (int unValor,Coordinador unE){
        this.estudio=unE;
        this.valor=unValor;
    }

    
    public void run() {
        try {
            if(valor%2==0){
                estudio.usarLibro();
                estudio.usarPC();
                Thread.sleep((int)(Math.random()*(3000-1000+1))+1000);
                estudio.dejarLibro();
                estudio.dejarPC();
            }else{
                estudio.usarPC();
                estudio.usarLibro();
                Thread.sleep((int)(Math.random()*(3000-1000+1))+1000);
                estudio.dejarPC();
                estudio.dejarLibro();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

}
