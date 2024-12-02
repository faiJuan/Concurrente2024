package TPO;

import java.util.Random;

public class Visitante implements Runnable{
    private ControlParque control;
    private Parque parque;
    private int opcion;
    private boolean permiso;

    public Visitante(ControlParque unC,Parque unP) {
        this.control=unC;
        this.parque=unP;
        this.opcion=0;
    }

    public void run(){
        try {
            control.entrarParque();

            parque.tren.subirTren(Thread.currentThread().getName());
            parque.tren.bajarTren();
            /*permiso=control.getPermisoComienzo();
            while (permiso) {
                opcion=new Random().nextInt(8)+1;
                switch (2) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        parque.barco.subirBarco();
                        
                        parque.barco.bajarBarco();
                            
                        permiso=control.getPermisoComienzo();
                        break;
                    case 4:

                        break;
                    case 5:
                        
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:
                        
                        break;
                    default:
                        break;
                }
                /*if(opcion==9){
                    //la opcion 9 simula que el visitante se fue voluntariamente antes de que cierre el parque
                    permiso=false;
                }else{
                    permiso=control.getPermisoComienzo();
                }*/
                
            
            //System.out.println(Thread.currentThread().getName()+" se fue del parque");
            //System.out.println("");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
