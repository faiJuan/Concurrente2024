package TPO;

public class EncargadoAutos implements Runnable{
    private AutoChocador autos;

    public EncargadoAutos(AutoChocador unA){
        this.autos=unA;
    }
    
    public void run() {
        try {
            while (true) {
                autos.empezarJuego();
                Thread.sleep(2000);
                autos.terminarJuego();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
