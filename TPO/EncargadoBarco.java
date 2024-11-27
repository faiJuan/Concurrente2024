package TPO;

public class EncargadoBarco implements Runnable{
    private BarcoPirata barco;

    public EncargadoBarco(BarcoPirata unbarco){
        this.barco=unbarco;
    }

    public void run(){
        try {
            while(true){
                barco.empezarJuegoBarco();
                Thread.sleep(3000);
                barco.terminarJuegoBarco();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
