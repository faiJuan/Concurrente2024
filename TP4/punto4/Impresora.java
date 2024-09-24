package TP4.punto4;

public class Impresora {
    private boolean ocupado;

    public Impresora() {
        this.ocupado = false;
    }

    public void usarImpresora() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esta imprimiendo");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " termino de imprimir");
        ocupado = false;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void cambiarEstado() {
        ocupado = true;
    }
}
