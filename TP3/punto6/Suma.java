package TP3.punto6;

public class Suma {
    private int total;
    public Suma(){
        this.total=0;
    }
    public synchronized void setSuma(int sumatoria){
        total=total+sumatoria;
    }

    public int obtenerTotal (){
        return total;
    }
}
