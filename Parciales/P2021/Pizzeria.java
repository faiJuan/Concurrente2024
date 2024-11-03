package Parciales.P2021;

import java.util.concurrent.Semaphore;

public class Pizzeria {
    private Semaphore hayPedido,hayLugar,mutex;
    private int pedidosMax,pedidosActuales;

    public Pizzeria (int cant){
        this.pedidosMax=cant;
        hayPedido=new Semaphore (0);
        hayLugar=new Semaphore(pedidosMax);
        mutex=new Semaphore(1);
        this.pedidosActuales=0;
    }

    public void ponerPedido()throws InterruptedException{
        hayLugar.acquire();
        mutex.acquire();
        pedidosActuales++;
        mutex.release();
        hayPedido.release();
    }

    public void sacarPedido()throws InterruptedException{
        hayPedido.acquire();
        mutex.acquire();
        pedidosActuales--;
        mutex.release();
        hayLugar.release();
    }
}
