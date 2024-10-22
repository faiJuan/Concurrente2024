package TP6.punto3;

public class Buffer {
    private int cantProductos,limite;

public Buffer (int unL){
    this.cantProductos=0;
    this.limite=unL;
}

public synchronized void producir() throws InterruptedException{
    while(cantProductos>limite){
        wait();
    }
    cantProductos++;
    System.out.println("EL productor coloco un producto");
    notify();
}
public synchronized void consumir ()throws InterruptedException{
    while(cantProductos<=0){
        wait();
    }
    cantProductos--;
    System.out.println("El consumidor saco un producto");
    notify();
}

}
