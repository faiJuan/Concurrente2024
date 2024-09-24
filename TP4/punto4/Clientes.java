package TP4.punto4;

public class Clientes implements Runnable {
    private GestorImpresoras gestor = new GestorImpresoras();
    public Clientes (GestorImpresoras unG){
        this.gestor=unG;
    }

    public void run() {
        try {
            while (true) {
                gestor.imprimir();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
