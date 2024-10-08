package TP5.punto5;

import java.util.concurrent.Semaphore;

public class Tren {
private Semaphore pasajeros,mutex,mutex2,vendedor;
private int cantidadPasajeros,ticketsVendidos;   


public Tren (int cantP){
    pasajeros=new Semaphore (0);
    vendedor=new Semaphore (0);
    mutex=new Semaphore (1);
    mutex2=new Semaphore(1);
    cantidadPasajeros=cantP;
    ticketsVendidos=0;
}

public void subirTren() throws InterruptedException{
mutex2.acquire();

}

public void bajarTren(){

}

public void comprarTickets () throws InterruptedException{
mutex.acquire();
System.out.println(Thread.currentThread().getName()+" quiere comprar un ticket");
vendedor.release();
mutex.release();

}

public void venderTickets()throws InterruptedException{
vendedor.acquire();
System.out.println("Se vendio un ticket");
ticketsVendidos++;

}
}
