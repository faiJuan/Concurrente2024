package TPO;


public class EncargadoBarco implements Runnable{
    private Parque parque;
    private ControlParque control;
    public EncargadoBarco(Parque unP,ControlParque unC){
        this.parque=unP;
        this.control=unC;
    }

    public void run(){
        try {
            control.entrarParque();
            while(control.getPermisoComienzo()){
                parque.barco.empezarJuegoBarco();
                Thread.sleep(3000);
                parque.barco.terminarJuegoBarco();
            }
            parque.barco.cerrarJuego();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
