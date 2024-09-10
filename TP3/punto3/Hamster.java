package TP3.punto3;

public class Hamster implements Runnable{
    private Rueda rueda;
    private Hamaca hamaca;
    private Plato plato;
    public Hamster (Plato unP, Hamaca unH, Rueda unaR){
        this.plato=unP;
        this.hamaca=unH;
        this.rueda=unaR;
    }

    
    public void run() {
        try {
            while(true){
                rueda.usarRueda();
                hamaca.usarHamaca();
                plato.usarPlato();
            }
        } catch (Exception e) {
            
        }
    }
}
