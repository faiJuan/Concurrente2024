package TPO;

public class Maquinista implements Runnable{
    private Parque parque;
    private ControlParque control;
    public Maquinista(Parque unP,ControlParque unC){
        this.parque=unP;
        this.control=unC;
    }

    public void run(){
        try {
            control.entrarParque();
            while (control.getPermisoComienzo()) {
                parque.tren.empezarViaje();
                Thread.sleep(2000);
                parque.tren.terminarViaje();
            }
            parque.tren.terminarJuego();
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

