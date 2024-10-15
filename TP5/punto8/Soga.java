package TP5.punto8;

import java.util.concurrent.Semaphore;

public class Soga {
    private Semaphore mutex,ladoA,ladoB,controlador,mutex2;
    private int cantidadEnsoga, quierenPasarA,quierenPasarB,totalA,totalB;
    private char turno;
    public Soga() {
        this.cantidadEnsoga=5;
        mutex=new Semaphore (1);
        ladoA=new Semaphore(0);
        ladoB=new Semaphore(0);
        controlador=new Semaphore(0);
        mutex2=new Semaphore(1);
        this.turno='-';
        this.quierenPasarA=0;
        this.quierenPasarB=0;
        this.totalA=0;
        this.totalB=0;
    }

    public void cruzarLadoA (char lado) throws InterruptedException{
        mutex.acquire();
        quierenPasarA++;
        if(turno=='-'){
            turno='A';
            controlador.release();
        }
        mutex.release();
        ladoA.acquire();
        System.out.println(Thread.currentThread().getName()+" "+lado+" esta cruzando");
    }

    
    public void terminarA()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" se bajo de la soga");
        mutex2.acquire();
        cantidadEnsoga--;
        quierenPasarA--;
        totalA++;
        if(cantidadEnsoga==0){
            controlador.release();
        }
        mutex2.release();
    }


    public void cruzarLadoB (char lado) throws InterruptedException{
        mutex.acquire();
        quierenPasarB++;
        if(turno=='-'){
            turno='B';
            controlador.release();
        }
        mutex.release();
        ladoB.acquire();
        System.out.println(Thread.currentThread().getName()+" "+lado+" esta cruzando");
    }


    public void terminarB ()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" se bajo de la soga");
        mutex2.acquire();
        cantidadEnsoga--;
        quierenPasarB--;
        totalB++;
        if(cantidadEnsoga==0){
            controlador.release();
        }
        mutex2.release();
    }

    
    

    public boolean controlador ()throws InterruptedException{
        controlador.acquire();
        boolean termino=false;
        if(quierenPasarA==0 && quierenPasarB==0){
            termino=true;
        }

        if(turno=='A'){
            turno='B';
            if(quierenPasarB>=5){
                cantidadEnsoga=5;
                ladoB.release(5);
            }else{
                if(quierenPasarB==0){
                    controlador.release();
                }else{
                    cantidadEnsoga=quierenPasarB;
                    ladoB.release(quierenPasarB);
                }
            }
        }else if(turno=='B'){
            turno='A';
            if(quierenPasarA>=5){
                cantidadEnsoga=5;
                ladoA.release(5);
            }else{
                if(quierenPasarA==0){
                    controlador.release();
                }else{
                    cantidadEnsoga=quierenPasarA;
                    ladoA.release(quierenPasarA);
                }
            }
        }
        return termino;
    }

    public void cruzaron (){
        System.out.println("Cruzaron "+totalA+" babuinos del lado A");
        System.out.println("Cruzaron "+totalB+" babuinos del lado B");
        totalA=0;
        totalB=0;
    }
    
}
