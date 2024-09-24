package TP4.punto4;

public class Main {
    public static void main(String[] args) {
        Thread [] clientes=new Thread[7];
        GestorImpresoras gestor= new GestorImpresoras();

        for (int i = 0; i < clientes.length; i++) {
            clientes[i]= new Thread(new Clientes(gestor));
            clientes[i].start();
        }
    }
}
