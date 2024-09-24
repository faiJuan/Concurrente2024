package TP4.punto4;

import java.util.concurrent.Semaphore;

public class GestorImpresoras {
    private Impresora i1, i2, i3;
    private Semaphore mutex1;

    public GestorImpresoras() {
        this.i1 = new Impresora();
        this.i2 = new Impresora();
        this.i3 = new Impresora();

        mutex1 = new Semaphore(1,true);

    }

    public void imprimir() throws InterruptedException {
        mutex1.acquire();
        if (!i1.estaOcupado()) {
            i1.cambiarEstado();
            mutex1.release();
            i1.usarImpresora();
        } else if (!i2.estaOcupado()) {
            i2.cambiarEstado();
            mutex1.release();
            i2.usarImpresora();
        } else if (!i3.estaOcupado()) {
            i3.cambiarEstado();
            mutex1.release();
            i3.usarImpresora();
        } else {
            mutex1.release();
        }
    }
}
