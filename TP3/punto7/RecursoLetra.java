package TP3.punto7;

public class RecursoLetra {
    private String letra;
    public RecursoLetra (String unaL){
        this.letra=unaL;
    }
    public synchronized void imprimirLetra(){
        System.out.print(letra);
    }
}
