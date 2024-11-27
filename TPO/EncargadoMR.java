package TPO;

public class EncargadoMR implements Runnable{
    private MontañaRusa montaña;

    public EncargadoMR(MontañaRusa unaM){
        this.montaña=unaM;
    }

    public void run(){
        try {
            while(true){
                montaña.arrancarJuego();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
