package TP4.punto7;

import java.util.concurrent.Semaphore;

public class Silla {
    private Semaphore cliente;
    private Semaphore mozo;
    private Semaphore mutex;

    public Silla() {
        cliente = new Semaphore(1);
        mozo = new Semaphore(0);
        mutex = new Semaphore (0);
    }

    public void sentarseComer() throws InterruptedException {
        cliente.acquire();
        System.out.println(Thread.currentThread().getName() + " se sento a comer");
        System.out.println("eligiendo menu");
        Thread.sleep(1000);
        System.out.println("menu elegido");
        mozo.release();
        mutex.acquire();
        System.out.println(Thread.currentThread().getName() + " empezo a comer");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " termino de comer");
        cliente.release();

    }

    public void prepararComida() throws InterruptedException {
        mozo.acquire();
        System.out.println("preparando comida");
        Thread.sleep(3000);
        System.out.println("comida servida, puede empezar a comer");
        System.out.println("inventado nevas comidas");
        mutex.release();
    }

}
