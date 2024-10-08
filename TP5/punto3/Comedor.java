package TP5.punto3;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantComederos, gatosQuierenComer, perrosQuierenComer, cantComiendo;
    private Semaphore controlador, perros, gatos, mutex, mutex2;
    private char turno;

    public Comedor(int cant) {
        this.gatosQuierenComer = 0;
        this.perrosQuierenComer = 0;
        this.cantComiendo = cant;
        this.cantComederos = cant;
        this.turno = '-';
        this.controlador = new Semaphore(1);
        this.mutex = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
        this.perros = new Semaphore(0);
        this.gatos = new Semaphore(0);
    }

    public void empezarComerGato() throws InterruptedException {
        mutex.acquire();
        gatosQuierenComer++;
        if (turno == '-') {
            turno = 'G';
        }
        mutex.release();

        gatos.acquire();

        System.out.println(Thread.currentThread().getName() + " gato empezo a comer");
        
        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + " gato termino de comer");
        mutex2.acquire();
        cantComiendo--;
        gatosQuierenComer--;
        if (cantComiendo == 0) {
            controlador.release();
        }
        mutex2.release();
    }

    public void empezarComerPerro() throws InterruptedException {
        mutex.acquire();
        if (turno == '-') {
            turno = 'P';
        }
        perrosQuierenComer++;
        mutex.release();
        
        perros.acquire();
        
        System.out.println(Thread.currentThread().getName() + " perro empezo a comer");
    
        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + " perro termino de comer");
        mutex2.acquire();
        cantComiendo--;
        perrosQuierenComer--;
        if (cantComiendo == 0) {
            controlador.release();

        }
        mutex2.release();
    }

    public void controlarComedor() throws InterruptedException {
        controlador.acquire();
        if (perrosQuierenComer >= 5 && turno == 'G') {
            turno = 'P';
            perros.release(cantComederos);
            cantComiendo = cantComederos;
        } else if (perrosQuierenComer < 5 && turno == 'G') {
            if (perrosQuierenComer == 0) {
                turno = 'P';
                controlador.release();
            } else {
                turno = 'P';
                perros.release(perrosQuierenComer);
                cantComiendo = perrosQuierenComer;
            }
        } else if (gatosQuierenComer >= 5 && turno == 'P') {
            turno = 'G';
            gatos.release(cantComederos);
            cantComiendo = cantComederos;
        } else if (gatosQuierenComer < 5 && turno == 'P') {
            if (gatosQuierenComer == 0) {
                turno = 'G';
                controlador.release();
            } else {
                turno = 'G';
                gatos.release(gatosQuierenComer);
                cantComiendo = gatosQuierenComer;
            }

        }

    }

}
