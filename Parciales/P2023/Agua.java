package Parciales.P2023;

import java.util.concurrent.Semaphore;

public class Agua {

    private Semaphore hidrogeno, oxigeno, mutex, aguaEnEspera;
    private int cantO, cantH, cantAgua, aguaLista;

    public Agua() {
        cantO = 0;
        cantH = 0;
        hidrogeno = new Semaphore(2);
        oxigeno = new Semaphore(1);
        aguaEnEspera = new Semaphore(0);
        cantAgua = 0;
        aguaLista = 0;
    }

    public void Hlisto() throws InterruptedException {
        hidrogeno.acquire();
        mutex.acquire();
        aguaLista++;
        mutex.release();
        if (aguaLista == 3) {
            this.hacerAgua();
        } else {
            aguaEnEspera.acquire();
            hidrogeno.release(2);
        }
    }

    public void Olisto() throws InterruptedException {
        oxigeno.acquire();
        mutex.acquire();
        aguaLista++;
        mutex.release();
        if (aguaLista == 3) {
            this.hacerAgua();
        } else {
            aguaEnEspera.acquire();
            oxigeno.release(1);
        }
    }

    public void hacerAgua() throws InterruptedException {
        mutex.acquire();
        aguaLista = 0;
        cantAgua++;
        if (cantAgua > 10) {
            System.out.println("liberando agua");
            cantAgua = 0;
        }
        mutex.release();
        aguaEnEspera.release(2);
    }
}
