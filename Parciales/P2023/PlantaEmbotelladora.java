package Parciales.P2023;

import java.util.concurrent.Semaphore;

public class PlantaEmbotelladora {
    private Semaphore embotelladoresV,embotelladoresA,sEmpaquetador,sTransporte,mutexV,mutexA,mutex2,mutex3;
    private int cajaVino,cajaAgua,cajasEnEspera;
    private char ultimo;
    private boolean ocupado;

    public PlantaEmbotelladora(){
        embotelladoresA=new Semaphore(10);//traba los hilos para que entren solo la cantidad necesaria
        embotelladoresV=new Semaphore(10);
        sEmpaquetador=new Semaphore(0);//habilita al empaquetador cuando se llena una caja
        sTransporte=new Semaphore(0);//habilita al transportador cuando se llena el almacen
        mutexV=new Semaphore(1);//controla que se llenen de a 1 las cajas V
        mutexA=new Semaphore(1);//controla que se llenen de a 1 las cajas A
        mutex2=new Semaphore(1);//
        mutex3=new Semaphore(0);
        cajaVino=0;
        cajaAgua=0;
        ultimo='-';
        ocupado=false;
        cajasEnEspera=0;
    }
 
 // miau miau miau miauu
    public void embotellarVino()throws InterruptedException{
        embotelladoresV.acquire();
        mutexV.acquire();
        cajaVino++;
        System.out.println("Se puso un vino en la caja");
        mutexV.release();
        mutex2.acquire();
        if(cajaVino>=10){
            if(!ocupado){
                ultimo='V';
                sEmpaquetador.release();

            }else{
                cajasEnEspera++;
                mutex3.acquire();
                ultimo='V';
                sEmpaquetador.release();
            }
        }
        mutex2.release();
 
    }
}
