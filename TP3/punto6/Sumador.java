package TP3.punto6;

public class Sumador implements Runnable{
    private int inicio;
    private int fin;
    private int [] arre;
    private int total;
    private Suma recurso;

    public Sumador(int ini, int f, int[]recu,Suma sumatoria){
        this.inicio=ini;
        this.fin=f;
        this.arre=recu;
        this.total=0;
        this.recurso=sumatoria;
    }       

public void run (){
    try {
        while(inicio<=fin){
            total=total+arre[inicio];
            inicio++;
        }
        recurso.setSuma(total);
        System.out.println(Thread.currentThread().getName()+" sumo un total de: "+total);
    } catch (Exception e) {
        // TODO: handle exception
    }
}
    



}
