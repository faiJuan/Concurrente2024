package TPO;


public class Visitante implements Runnable{
    private TrenTuristico tren;
    public Visitante(TrenTuristico unTren) {
        this.tren=unTren;
    }

    public void run(){
        try {
            tren.subirTren(Thread.currentThread().getName());
            tren.bajarTren();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
