package TP4.punto8;

import java.util.concurrent.Semaphore;

public class Produccion {
    private Semaphore sElectrico,sMecanico,mutex,mutex2;
    private int contadorElectrico,contadorMecanico;
    private char turno;
    public Produccion (){
        sElectrico= new Semaphore(0,true);
        sMecanico=new Semaphore(0,true);
        mutex= new Semaphore(1);
        mutex2=new Semaphore(1);
        this.contadorElectrico=0;
        this.contadorMecanico=0;
        this.turno='-';
    }

    public void llegaElectrico () throws InterruptedException{
        mutex.acquire();
        if(turno=='-'){
            this.turno='E';
        }
        contadorElectrico++;
        mutex.release();
        sElectrico.acquire();
        System.out.println("Pasa electrico");
        this.turno='M';
        contadorElectrico--;
        mutex2.release();
        
    }

    public void llegaMecanico () throws InterruptedException{
        mutex.acquire();
        if(turno=='-'){
            this.turno='M';
        }
        contadorMecanico++;
        mutex.release();
        sMecanico.acquire();
        System.out.println("Pasa Mecanico");
        this.turno='E';
        contadorMecanico--;
        mutex2.release();
  
        
    }

    public boolean controlador () throws InterruptedException{
        boolean termino=false;
        mutex2.acquire();
        
        if(contadorElectrico>0 && turno=='E'){
            sElectrico.release();

        }else if(contadorElectrico==0 && turno=='E'){
            sMecanico.release();
        }else if(contadorMecanico>0 && turno=='M'){
            sMecanico.release();
        }else if(contadorMecanico==0 && turno=='M'){
            sElectrico.release();
        }

        if(contadorElectrico==0 && contadorMecanico==0 /*&& !(turno=='-')*/){
            //si ingresa primero el hilo controlador el sistema termina, hay que ver como cambiarlo
            mutex2.release();
            mutex.release();
            termino=true;
        }
        return termino;
        
    }

    

}
