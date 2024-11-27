package TPO;


public class Visitante implements Runnable{
    private BarcoPirata montaña;
    public Visitante(BarcoPirata unam) {
        this.montaña=unam;
    }

    public void run(){
        try {
            montaña.subirBarco();
            montaña.bajarBarco();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
