package TP4.punto8;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private Semaphore sElectrico,sMecanico,mutex;
    public ControladorProduccion (){
        sElectrico= new Semaphore(1,true);
        sMecanico=new Semaphore(1,true);
        mutex= new Semaphore(0);
    }

    public void llegaElectrico (){
        
        
    }

}
